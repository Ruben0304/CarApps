package ruben.hernandez.rentalcar.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.repositories.SettingsRepository

data class SettingsUiState(
    val isDarkMode: Boolean = false,
    val notificationsEnabled: Boolean = false,
    val soundsEnabled: Boolean = false,
    val preferredService: String = "Consultas"
)

sealed class SettingsEvent {
    object NavigateToAccount : SettingsEvent()
}

class SettingsViewModel(
    private val repository: SettingsRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    private val _navigationEvent = MutableSharedFlow<SettingsEvent>()
    val navigationEvent = _navigationEvent.asSharedFlow()

    init {
        loadSettings()
    }

    private fun loadSettings() {
        viewModelScope.launch {
            _uiState.value = SettingsUiState(
                isDarkMode = repository.getThemeMode(),
                notificationsEnabled = repository.getNotificationsEnabled(),
                soundsEnabled = repository.getSoundsEnabled(),
                preferredService = repository.getPreferredService()
            )
        }
    }

    fun loadAccount() {
        viewModelScope.launch {
            _navigationEvent.emit(SettingsEvent.NavigateToAccount)
        }
    }

    fun updateTheme(isDarkMode: Boolean) {
        viewModelScope.launch {
            repository.setThemeMode(isDarkMode)
            _uiState.value = _uiState.value.copy(isDarkMode = isDarkMode)
            AppColors.darkMode = isDarkMode
        }
    }

    fun updateNotifications(enabled: Boolean) {
        viewModelScope.launch {
            repository.setNotificationsEnabled(enabled)
            _uiState.value = _uiState.value.copy(notificationsEnabled = enabled)
        }
    }

    fun updateSounds(enabled: Boolean) {
        viewModelScope.launch {
            repository.setSoundsEnabled(enabled)
            _uiState.value = _uiState.value.copy(soundsEnabled = enabled)
        }
    }

    fun updatePreferredService(service: String) {
        viewModelScope.launch {
            repository.setPreferredService(service)
            _uiState.value = _uiState.value.copy(preferredService = service)
        }
    }
}
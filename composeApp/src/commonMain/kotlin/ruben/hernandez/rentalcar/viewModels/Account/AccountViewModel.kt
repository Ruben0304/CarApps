package ruben.hernandez.rentalcar.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ruben.hernandez.rentalcar.repositories.AccountRepository
import ruben.hernandez.rentalcar.repositories.UserProfile
import ruben.hernandez.rentalcar.repositories.CarInfo

data class AccountUiState(
    val isLoading: Boolean = false,
    val userProfile: UserProfile? = null,
    val error: String? = null
)

sealed class AccountEvent {
    object NavigateToSettings : AccountEvent()
    data class ShowError(val message: String) : AccountEvent()
    object PhotoUpdated : AccountEvent()
}

class AccountViewModel(
    private val repository: AccountRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(AccountUiState())
    val uiState: StateFlow<AccountUiState> = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<AccountEvent>()
    val events = _events.asSharedFlow()

    init {
        loadUserProfile()
    }

    private fun loadUserProfile() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                val profile = repository.getUserProfile()
                _uiState.value = AccountUiState(userProfile = profile)
            } catch (e: Exception) {
                _uiState.value = AccountUiState(error = e.message)
                _events.emit(AccountEvent.ShowError(e.message ?: "Error desconocido"))
            }
        }
    }

    fun updateProfilePhoto(photoUri: String) {
        viewModelScope.launch {
            try {
                repository.updateProfilePhoto(photoUri)
                loadUserProfile()
                _events.emit(AccountEvent.PhotoUpdated)
            } catch (e: Exception) {
                _events.emit(AccountEvent.ShowError(e.message ?: "Error al actualizar la foto"))
            }
        }
    }

    fun updateCarInfo(carInfo: CarInfo) {
        viewModelScope.launch {
            try {
                repository.updateCarInfo(carInfo)
                loadUserProfile()
            } catch (e: Exception) {
                _events.emit(AccountEvent.ShowError(e.message ?: "Error al actualizar información del auto"))
            }
        }
    }

    fun navigateToSettings() {
        viewModelScope.launch {
            _events.emit(AccountEvent.NavigateToSettings)
        }
    }
}
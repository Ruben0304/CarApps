package ruben.hernandez.rentalcar.Implementations

import ruben.hernandez.rentalcar.repositories.SettingsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class SettingsImplementation(private val dispatcher: CoroutineDispatcher) : SettingsRepository {
    // Usaremos variables en memoria para el ejemplo
    private var isDarkMode = false
    private var notificationsEnabled = false
    private var soundsEnabled = false
    private var preferredService = "Consultas"

    override suspend fun getThemeMode(): Boolean = withContext(dispatcher) {
        isDarkMode
    }

    override suspend fun setThemeMode(isDarkMode: Boolean) = withContext(dispatcher) {
        this@SettingsImplementation.isDarkMode = isDarkMode
    }

    override suspend fun getNotificationsEnabled(): Boolean = withContext(dispatcher) {
        notificationsEnabled
    }

    override suspend fun setNotificationsEnabled(enabled: Boolean) = withContext(dispatcher) {
        notificationsEnabled = enabled
    }

    override suspend fun getSoundsEnabled(): Boolean = withContext(dispatcher) {
        soundsEnabled
    }

    override suspend fun setSoundsEnabled(enabled: Boolean) = withContext(dispatcher) {
        soundsEnabled = enabled
    }

    override suspend fun getPreferredService(): String = withContext(dispatcher) {
        preferredService
    }

    override suspend fun setPreferredService(service: String) = withContext(dispatcher) {
        preferredService = service
    }
}


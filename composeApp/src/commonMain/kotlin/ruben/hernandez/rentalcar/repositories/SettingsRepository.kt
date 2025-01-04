package ruben.hernandez.rentalcar.repositories

interface SettingsRepository {
    suspend fun getThemeMode(): Boolean
    suspend fun setThemeMode(isDarkMode: Boolean)
    suspend fun getNotificationsEnabled(): Boolean
    suspend fun setNotificationsEnabled(enabled: Boolean)
    suspend fun getSoundsEnabled(): Boolean
    suspend fun setSoundsEnabled(enabled: Boolean)
    suspend fun getPreferredService(): String
    suspend fun setPreferredService(service: String)
}
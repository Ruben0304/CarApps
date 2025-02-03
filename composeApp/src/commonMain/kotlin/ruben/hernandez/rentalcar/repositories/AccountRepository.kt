package ruben.hernandez.rentalcar.repositories

interface AccountRepository {
    suspend fun getUserProfile(): UserProfile
    suspend fun updateUserProfile(profile: UserProfile)
    suspend fun updateProfilePhoto(photoUri: String)
    suspend fun updateUsername(username: String)
    suspend fun updatePassword(oldPassword: String, newPassword: String)
    suspend fun updateCarInfo(carInfo: CarInfo)
}

data class UserProfile(
    val username: String,
    val photoUrl: String,
    val firstName: String,
    val lastName: String,
    val location: String,
    val carInfo: CarInfo
)

data class CarInfo(
    val brand: String,
    val model: String,
    val year: String
)


package ruben.hernandez.rentalcar.implementations

import ruben.hernandez.rentalcar.repositories.AccountRepository
import ruben.hernandez.rentalcar.repositories.UserProfile
import ruben.hernandez.rentalcar.repositories.CarInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class AccountImplementation(
    private val dispatcher: CoroutineDispatcher
) : AccountRepository {
    // In-memory storage for example purposes
    private var userProfile = UserProfile(
        username = "ruben.hernandez",
        photoUrl = "",
        firstName = "Ruben",
        lastName = "Hernandez",
        location = "Ciudad de México",
        carInfo = CarInfo(
            brand = "Toyota",
            model = "Corolla",
            year = "2023"
        )
    )

    override suspend fun getUserProfile(): UserProfile = withContext(dispatcher) {
        userProfile
    }

    override suspend fun updateUserProfile(profile: UserProfile) = withContext(dispatcher) {
        userProfile = profile
    }

    override suspend fun updateProfilePhoto(photoUri: String) = withContext(dispatcher) {
        userProfile = userProfile.copy(photoUrl = photoUri)
    }

    override suspend fun updateUsername(username: String) = withContext(dispatcher) {
        userProfile = userProfile.copy(username = username)
    }

    override suspend fun updatePassword(oldPassword: String, newPassword: String) = withContext(dispatcher) {
        // Implement password update logic
    }

    override suspend fun updateCarInfo(carInfo: CarInfo) = withContext(dispatcher) {
        userProfile = userProfile.copy(carInfo = carInfo)
    }
}


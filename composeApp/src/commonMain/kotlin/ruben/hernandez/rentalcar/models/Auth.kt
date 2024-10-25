package ruben.hernandez.rentalcar.models

// Los tipos de datos necesarios
data class AuthPayload(
    val token: String,
    val user: User
)

data class User(
    val id: String,
    val username: String,
    val phone: String,
    val fullName: String
)
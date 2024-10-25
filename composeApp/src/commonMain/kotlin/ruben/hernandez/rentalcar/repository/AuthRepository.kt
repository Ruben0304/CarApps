package ruben.hernandez.rentalcar.repository

import ruben.hernandez.rentalcar.LoginMutation
import ruben.hernandez.rentalcar.RegisterMutation
import ruben.hernandez.rentalcar.apollo.ApolloGraphQL
import ruben.hernandez.rentalcar.models.AuthPayload
import ruben.hernandez.rentalcar.models.User

object AuthRepository {
    // El AuthRepository podría verse así:
    suspend fun login(username: String, password: String): Result<AuthPayload> {
        return try {
            val response = ApolloGraphQL.apolloClient.mutation(
                LoginMutation(
                    username = username,
                    password = password
                )
            ).execute()

            response.data?.login?.let { loginData ->
                // Mapear LoginMutation.Login a AuthPayload manualmente
                val authPayload = AuthPayload(
                    token = loginData.token,
                    user = User(
                        id = loginData.user.id,
                        username = loginData.user.username,
                        phone = loginData.user.phone,
                        fullName = loginData.user.fullName
                    )
                )

                // Guardar el token aquí o en un TokenManager separado
                saveToken(authPayload.token)
                println(authPayload)
                Result.success(authPayload)
            } ?: Result.failure(Exception("Error en autenticación"))

        } catch (e: Exception) {
            Result.failure(e)
        }
    }


    suspend fun register(
        username: String,
        password: String,
        phone: String,
        fullName: String
    ): Result<AuthPayload> {
        return try {
            val response = ApolloGraphQL.apolloClient.mutation(
                RegisterMutation(
                    username = username,
                    password = password,
                    phone = phone,
                    fullName = fullName
                )
            ).execute()

            response.data?.register?.let { registerData ->
                // Mapear RegisterMutation.Register a AuthPayload manualmente
                val authPayload = AuthPayload(
                    token = registerData.token,
                    user = User(
                        id = registerData.user.id,
                        username = registerData.user.username,
                        phone = registerData.user.phone,
                        fullName = registerData.user.fullName
                    )
                )

                // Guardar el token aquí o en un TokenManager separado
                saveToken(authPayload.token)
                println(authPayload)
                Result.success(authPayload)
            } ?: Result.failure(Exception("Error en registro"))

        } catch (e: Exception) {
            Result.failure(e)
        }
    }


    private fun saveToken(token: String) {
        // Implementar guardado del token (DataStore o SharedPreferences)
    }


}
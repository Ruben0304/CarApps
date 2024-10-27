package ruben.hernandez.rentalcar.viewModels.Chat.Auth

import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import androidx.compose.ui.text.input.TextFieldValue
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import ruben.hernandez.rentalcar.repository.AuthRepository
import ruben.hernandez.rentalcar.models.AuthPayload

class LoginViewModel(private val authRepository: AuthRepository = AuthRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<LoginEvent>()
    val events = _events.asSharedFlow()

    fun onEmailChanged(email: TextFieldValue) {
        _uiState.update { it.copy(email = email) }
    }

    fun onPasswordChanged(password: TextFieldValue) {
        _uiState.update { it.copy(password = password) }
    }

    fun onNameChanged(name: TextFieldValue) {
        _uiState.update { it.copy(name = name) }
    }

    fun onConfirmPasswordChanged(confirmPassword: TextFieldValue) {
        _uiState.update { it.copy(confirmPassword = confirmPassword) }
    }

    fun onRegisterModeChanged(isRegistering: Boolean) {
        _uiState.update { it.copy(isRegistering = isRegistering) }
    }

    private fun validateInput(uiState: LoginUiState) {
        with(uiState) {
            when {
                email.text.isEmpty() -> throw Exception("El email es requerido")
                !email.text.contains("@") -> throw Exception("Email inválido")
                !email.text.contains(".") -> throw Exception("Email inválido")
                password.text.isEmpty() -> throw Exception("La contraseña es requerida")
                password.text.length < 6 -> throw Exception("La contraseña debe tener al menos 6 caracteres")
                isRegistering && name.text.isEmpty() -> throw Exception("El nombre es requerido")
                isRegistering && password.text != confirmPassword.text ->
                    throw Exception("Las contraseñas no coinciden")

                else -> {}
            }
        }
    }

    fun onLogin() {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(buttonState = ButtonState.Loading) }
                validateInput(_uiState.value)

                with(_uiState.value) {
                    if (isRegistering) {
                        // Registro de nuevo usuario
                        val result = authRepository.register(
                            username = email.text,
                            password = password.text,
                            phone = email.text,
                            fullName = name.text
                        )
                        handleAuthResult(result)
                    } else {
                        // Inicio de sesión
                        val result = authRepository.login(
                            username = email.text,
                            password = password.text
                        )
                        handleAuthResult(result)
                    }
                }
            } catch (e: Exception) {
                _events.emit(LoginEvent.ShowError(e.message ?: "Error desconocido"))
                _uiState.update { it.copy(buttonState = ButtonState.Idle) }
            }
        }
    }

    private suspend fun handleAuthResult(result: Result<AuthPayload>) {
        result.onSuccess {
            handleSuccessfulAuth()
        }.onFailure { e ->
            _events.emit(LoginEvent.ShowError(e.message ?: "Error en la autenticación"))
            _uiState.update { it.copy(buttonState = ButtonState.Idle) }
        }
    }

    private suspend fun handleSuccessfulAuth() {
        _uiState.update { it.copy(buttonState = ButtonState.Finished) }
        delay(650)
        _events.emit(LoginEvent.NavigateToHome)
    }
}


data class LoginUiState(
    val email: TextFieldValue = TextFieldValue(""),
    val password: TextFieldValue = TextFieldValue(""),
    val name: TextFieldValue = TextFieldValue(""),
    val confirmPassword: TextFieldValue = TextFieldValue(""),
    val isRegistering: Boolean = false,
    val buttonState: ButtonState = ButtonState.Idle
)

sealed class LoginEvent {
    object NavigateToHome : LoginEvent()
    data class ShowError(val message: String) : LoginEvent()
}

enum class ButtonState {
    Idle, Loading, Finished
}
//class LoginViewModel : ViewModel() {
//    private val _uiState = MutableStateFlow(LoginUiState())
//    val uiState = _uiState.asStateFlow()
//
//    private val _events = MutableSharedFlow<LoginEvent>()
//    val events = _events.asSharedFlow()
//
//    // Métodos para actualizar el estado de la interfaz
//    fun onEmailChanged(email: TextFieldValue) {
//        _uiState.update { it.copy(email = email) }
//    }
//
//    fun onPasswordChanged(password: TextFieldValue) {
//        _uiState.update { it.copy(passwordInput = password) }
//    }
//
//    fun onNameChanged(name: TextFieldValue) {
//        _uiState.update { it.copy(name = name) }
//    }
//
//    fun onConfirmPasswordChanged(confirmPassword: TextFieldValue) {
//        _uiState.update { it.copy(confirmPassword = confirmPassword) }
//    }
//
//    fun onRegisterModeChanged(isRegistering: Boolean) {
//        _uiState.update { it.copy(isRegistering = isRegistering) }
//    }
//
//    // Validación de entradas
//    private fun validateInput(uiState: LoginUiState) {
//        with(uiState) {
//            when {
//                email.text.isEmpty() -> throw Exception("El correo es requerido")
//                !email.text.contains("@") -> throw Exception("Correo inválido")
//                passwordInput.text.isEmpty() -> throw Exception("La contraseña es requerida")
//                passwordInput.text.length < 6 -> throw Exception("La contraseña debe tener al menos 6 caracteres")
//                isRegistering && name.text.isEmpty() -> throw Exception("El nombre es requerido")
//                isRegistering && passwordInput.text != confirmPassword.text ->
//                    throw Exception("Las contraseñas no coinciden")
//                else -> {}
//            }
//        }
//    }
//
//    // Función de autenticación para login y registro
//    fun onLogin() {
//        viewModelScope.launch {
//            try {
//                _uiState.update { it.copy(buttonState = ButtonState.Loading) }
//
//                // Validar input antes de continuar
//                validateInput(_uiState.value)
//
//                with(_uiState.value) {
//                    if (isRegistering) {
//                        // Registro de nuevo usuario
//                        AuthRepository.register(
//                            username = email.text,
//                            password = passwordInput.text,
//                            phone = email.text,
//                            fullName = name.text
//                        ).onSuccess {
//                            handleSuccessfulAuth()
//                        }.onFailure { e ->
//                            throw Exception("Error en el registro: ${e.message}")
//                        }
//                    } else {
//                        // Inicio de sesión
//                        AuthRepository.login(
//                            username = email.text,
//                            password = passwordInput.text
//                        ).onSuccess {
//                            handleSuccessfulAuth()
//                        }.onFailure { e ->
//                            throw Exception("Error en el inicio de sesión: ${e.message}")
//                        }
//                    }
//                }
//            } catch (e: Exception) {
//                _events.emit(LoginEvent.ShowError(e.message ?: "Error desconocido"))
//                _uiState.update { it.copy(buttonState = ButtonState.Idle) }
//            }
//        }
//    }
//
//    private suspend fun handleSuccessfulAuth() {
//        _uiState.update { it.copy(buttonState = ButtonState.Finished) }
//        delay(650) // Pequeña demora para mostrar la animación de éxito
//        _events.emit(LoginEvent.NavigateToHome)
//    }
//}
//
//// Modelos de estado de interfaz y eventos
//data class LoginUiState(
//    val email: TextFieldValue = TextFieldValue(""),
//    val passwordInput: TextFieldValue = TextFieldValue(""),
//    val name: TextFieldValue = TextFieldValue(""),
//    val confirmPassword: TextFieldValue = TextFieldValue(""),
//    val isRegistering: Boolean = false,
//    val buttonState: ButtonState = ButtonState.Idle
//)
//
//sealed class LoginEvent {
//    object NavigateToHome : LoginEvent()
//    data class ShowError(val message: String) : LoginEvent()
//}
//
//enum class ButtonState {
//    Idle, Loading, Finished
//}


//
//// Define tus tipos
//data class User(
//    val id: String,
//    val username: String,
//    val email: String
//)
//
//data class AuthPayload(
//    val token: String,
//    val user: User
//)
//
//class AuthRepository(private val apolloClient: ApolloClient) {
//    suspend fun login(username: String, password: String): Result<AuthPayload> {
//        return try {
//            val response = apolloClient.mutation(
//                LoginMutation(
//                    username = username,
//                    password = password
//                )
//            ).execute()
//
//            response.data?.login?.let { authPayload ->
//                Result.success(authPayload)
//            } ?: Result.failure(Exception("Error en autenticación"))
//
//        } catch (e: Exception) {
//            Result.failure(e)
//        }
//    }
//
//    suspend fun getCurrentUser(): Result<User> {
//        return try {
//            val response = apolloClient.query(MeQuery()).execute()
//
//            response.data?.me?.let { user ->
//                Result.success(user)
//            } ?: Result.failure(Exception("Usuario no encontrado"))
//
//        } catch (e: Exception) {
//            Result.failure(e)
//        }
//    }
//}
//
//// ViewModel
//class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {
//    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
//    val authState: StateFlow<AuthState> = _authState.asStateFlow()
//
//    fun login(username: String, password: String) {
//        viewModelScope.launch {
//            _authState.value = AuthState.Loading
//            authRepository.login(username, password)
//                .onSuccess { authPayload ->
//                    // Guardar token
//                    saveToken(authPayload.token)
//                    _authState.value = AuthState.Authenticated(authPayload.user)
//                }
//                .onFailure { error ->
//                    _authState.value = AuthState.Error(error.message ?: "Error desconocido")
//                }
//        }
//    }
//
//    fun checkAuthStatus() {
//        viewModelScope.launch {
//            _authState.value = AuthState.Loading
//            authRepository.getCurrentUser()
//                .onSuccess { user ->
//                    _authState.value = AuthState.Authenticated(user)
//                }
//                .onFailure {
//                    _authState.value = AuthState.Unauthenticated
//                }
//        }
//    }
//
//    private fun saveToken(token: String) {
//        // Guardar token en DataStore o SharedPreferences
//    }
//}
//
//sealed class AuthState {
//    object Idle : AuthState()
//    object Loading : AuthState()
//    object Unauthenticated : AuthState()
//    data class Authenticated(val user: User) : AuthState()
//    data class Error(val message: String) : AuthState()
//}
//
//// Configuración de Apollo Client
//class ApolloProvider(private val context: Context) {
//    fun provide(): ApolloClient {
//        return ApolloClient.Builder()
//            .serverUrl("tu_url_graphql")
//            .addHttpHeader("Authorization", getStoredToken())
//            .okHttpClient(
//                OkHttpClient.Builder()
//                    .addInterceptor { chain ->
//                        val original = chain.request()
//                        val builder = original.newBuilder()
//
//                        getStoredToken()?.let { token ->
//                            builder.addHeader("Authorization", "Bearer $token")
//                        }
//
//                        chain.proceed(builder.build())
//                    }
//                    .build()
//            )
//            .build()
//    }
//
//    private fun getStoredToken(): String? {
//        // Obtener token guardado
//    }
//}
//
//// UI en Compose
//@Composable
//fun LoginScreen(viewModel: AuthViewModel) {
//    val authState by viewModel.authState.collectAsState()
//
//    var username by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        OutlinedTextField(
//            value = username,
//            onValueChange = { username = it },
//            label = { Text("Usuario") }
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Contraseña") },
//            visualTransformation = PasswordVisualTransformation()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = { viewModel.login(username, password) },
//            enabled = authState !is AuthState.Loading
//        ) {
//            Text("Iniciar Sesión")
//        }
//
//        when (authState) {
//            is AuthState.Loading -> CircularProgressIndicator()
//            is AuthState.Error -> Text(
//                text = (authState as AuthState.Error).message,
//                color = Color.Red
//            )
//            is AuthState.Authenticated -> {
//                // Navegar a la pantalla principal
//            }
//            else -> Unit
//        }
//    }
//}
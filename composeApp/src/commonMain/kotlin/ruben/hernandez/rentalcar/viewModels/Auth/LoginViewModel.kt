package ruben.hernandez.rentalcar.viewModels.Auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name.asStateFlow()

    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword: StateFlow<String> = _confirmPassword.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private var _isRegistering = MutableStateFlow(false)
    var isRegistering: StateFlow<Boolean> = _isRegistering.asStateFlow()

    private val _loginEnable = MutableStateFlow(false)
    val loginEnable: StateFlow<Boolean> = _loginEnable.asStateFlow()

    // Funciones para actualizar los campos
    fun onEmailChanged(email: String) {
        _email.value = email
        checkLoginEnable()
    }

    fun onPasswordChanged(password: String) {
        _password.value = password
        checkLoginEnable()
    }

    fun onNameChanged(name: String) {
        _name.value = name
        checkLoginEnable()
    }

    fun onConfirmPasswordChanged(confirmPassword: String) {
        _confirmPassword.value = confirmPassword
        checkLoginEnable()
    }

    fun setLoading(loading: Boolean) {
        _isLoading.value = loading
    }

    fun toggleRegistering() {
        _isRegistering.update { !it }
        checkLoginEnable()
    }

    private fun checkLoginEnable() {
        _loginEnable.value = if (_isRegistering.value) {
            // Validación para registro
            _email.value.isNotEmpty() &&
                    _password.value.isNotEmpty() &&
                    _name.value.isNotEmpty() &&
                    _confirmPassword.value.isNotEmpty() &&
                    _password.value == _confirmPassword.value
        } else {
            _email.value.isNotEmpty() && _password.value.isNotEmpty()
        }
    }

//    private fun isValidPassword(password: String): Boolean =
//        password.length >= 6
//
//    private fun isValidEmail(email: String): Boolean {
//        val pattern = Regex(
//            "[a-zA-Z0-9+._%\\-]{1,256}" +
//                    "@" +
//                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
//                    "(" +
//                    "\\." +
//                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
//                    ")+"
//        )
//        return email.matches(pattern)
//    }
}
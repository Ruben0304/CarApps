package ruben.hernandez.rentalcar.views.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedContent

import androidx.compose.animation.animateContentSize

import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ruben.hernandez.rentalcar.views.components.common.BackButton
import ruben.hernandez.rentalcar.views.components.auth.CustomTextField
import ruben.hernandez.rentalcar.views.components.auth.ForgotPassword
import ruben.hernandez.rentalcar.views.components.auth.LoginButton
import ruben.hernandez.rentalcar.views.components.auth.LoginLogo
import ruben.hernandez.rentalcar.views.components.auth.LoginTitle
import ruben.hernandez.rentalcar.views.components.auth.SocialIcons
import androidx.compose.animation.core.Spring
import androidx.compose.animation.togetherWith

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import ruben.hernandez.rentalcar.AppColors

import ruben.hernandez.rentalcar.viewModels.Chat.Auth.LoginEvent
import ruben.hernandez.rentalcar.viewModels.Chat.Auth.LoginViewModel

import ruben.hernandez.rentalcar.views.poppinsFontFamily


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(),
    onLoginSuccess: () -> Unit,
    onLoginCancel: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    // Recolectar eventos del ViewModel
    LaunchedEffect(true) {
        viewModel.events.collect { event ->
            when (event) {
                is LoginEvent.NavigateToHome -> onLoginSuccess()
                is LoginEvent.ShowError -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0x7AB4BBC2))
            .pointerInput(Unit) {
                detectTapGestures { }
            },
        contentAlignment = Alignment.Center
    ) {
        BackButton(
            onLoginCancel,
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp)
                .size(45.dp)
                .align(Alignment.TopStart)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            LoginLogo()
            Spacer(modifier = Modifier.height(24.dp))
            LoginTitle()
            Spacer(modifier = Modifier.height(40.dp))

            AnimatedContent(
                targetState = uiState.isRegistering,
                transitionSpec = {
                    (fadeIn(animationSpec = tween(300, delayMillis = 300)) +
                            slideInVertically(
                                initialOffsetY = { -40 },
                                animationSpec = tween(300, delayMillis = 300)
                            )).togetherWith(
                        fadeOut(animationSpec = tween(300)) +
                                slideOutVertically(animationSpec = tween(300))
                    )
                }, label = ""
            ) { isReg ->
                Column(
                    modifier = Modifier.animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                ) {
                    if (isReg) {
                        CustomTextField(
                            value = uiState.name,
                            onValueChange = { viewModel.onNameChanged(it) },
                            placeholder = "Nombre",
                            textColor = AppColors.navColor,
                            modifier = Modifier.fillMaxWidth(.9f)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    CustomTextField(
                        value = uiState.email,
                        onValueChange = { viewModel.onEmailChanged(it) },
                        placeholder = "Email",
                        textColor = AppColors.navColor,
                        modifier = Modifier.fillMaxWidth(.9f)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    CustomTextField(
                        value = uiState.password,
                        onValueChange = { viewModel.onPasswordChanged(it) },
                        placeholder = "Password",
                        textColor = AppColors.navColor,
                        isPassword = true,
                        modifier = Modifier.fillMaxWidth(.9f),
                        showForgotPassword = !isReg
                    )

                    if (!isReg) {
                        Spacer(modifier = Modifier.height(16.dp))
                        ForgotPassword(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                    }

                    if (isReg) {
                        Spacer(modifier = Modifier.height(16.dp))
                        CustomTextField(
                            value = uiState.confirmPassword,
                            onValueChange = { viewModel.onConfirmPasswordChanged(it) },
                            placeholder = "Confirmar Password",
                            textColor = AppColors.navColor,
                            isPassword = true,
                            modifier = Modifier.fillMaxWidth(.9f)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            LoginButton(
                buttonState = uiState.buttonState,
                onClick = { viewModel.onLogin() }
            )

            Spacer(modifier = Modifier.height(24.dp))
            SocialIcons(
                modifier = Modifier
                    .padding(vertical = 40.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (uiState.isRegistering) "¿Ya tienes cuenta? " else "¿No estás registrado? ",
                    color = Color.White,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Black.copy(alpha = 0.3f),
                            offset = Offset(2f, 2f),
                            blurRadius = 1f
                        )
                    )
                )
                Text(
                    text = if (uiState.isRegistering) "Iniciar sesión" else "Registrarse",
                    color = Color.Black,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .clickable { viewModel.onRegisterModeChanged(!uiState.isRegistering) }
                        .padding(start = 4.dp)
                )
            }
        }
    }
}
package ruben.hernandez.rentalcar.views.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.Animatable
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ruben.hernandez.rentalcar.views.components.BackButton
import ruben.hernandez.rentalcar.views.components.ButtonState
import ruben.hernandez.rentalcar.views.components.CustomTextField
import ruben.hernandez.rentalcar.views.components.ForgotPassword
import ruben.hernandez.rentalcar.views.components.LoginButton
import ruben.hernandez.rentalcar.views.components.LoginLogo
import ruben.hernandez.rentalcar.views.components.LoginTitle
import ruben.hernandez.rentalcar.views.components.SocialIcons
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.*

import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.ui.input.pointer.pointerInput

import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import ruben.hernandez.rentalcar.views.poppinsFontFamily


@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable
fun PruebaLoginView() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
//        LoginScreen(
//            onLoginSuccess = {
//                // Acción tras login exitoso
//            }
//        )
    }
}


@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onLoginCancel: () -> Unit
) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue("")) }
    var buttonState by remember { mutableStateOf(ButtonState.Idle) }
    var isRegistering by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    val textColor = Color.Black
    val colorBackground = Color(0x7AB4BBC2)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorBackground)
            .pointerInput(Unit) {
                detectTapGestures { }  // Intercepta clicks sin hacer nada
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

            // Contenedor principal con animación
            AnimatedContent(
                targetState = isRegistering,
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
                            value = name,
                            onValueChange = { name = it },
                            placeholder = "Nombre",
                            textColor = textColor,
                            modifier = Modifier.fillMaxWidth(.9f)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    CustomTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholder = "Email",
                        textColor = textColor,
                        modifier = Modifier.fillMaxWidth(.9f)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    CustomTextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = "Password",
                        textColor = textColor,
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
                            value = confirmPassword,
                            onValueChange = { confirmPassword = it },
                            placeholder = "Confirmar Password",
                            textColor = textColor,
                            isPassword = true,
                            modifier = Modifier.fillMaxWidth(.9f)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            LoginButton(
                buttonState = buttonState,
                onClick = {
                    buttonState = ButtonState.Loading
                    coroutineScope.launch {
                        delay(1000)
                        buttonState = ButtonState.Finished
                        delay(650)
                        onLoginSuccess()
                    }
                }
            )
            Spacer(modifier = Modifier.height(24.dp))
            SocialIcons(modifier = Modifier.padding(vertical = 40.dp).fillMaxWidth())

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (isRegistering) "¿Ya tienes cuenta? " else "¿No estás registrado? ",
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
                    text = if (isRegistering) "Iniciar sesión" else "Registrarse",
                    color = Color.Black,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .clickable { isRegistering = !isRegistering }
                        .padding(start = 4.dp),

                )
            }
        }
    }
}
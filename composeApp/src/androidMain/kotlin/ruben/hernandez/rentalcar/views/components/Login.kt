package ruben.hernandez.rentalcar.views.components


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.GraphicsLayerScope
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.Car
import carrental.composeapp.generated.resources.Res
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ruben.hernandez.rentalcar.R
import ruben.hernandez.rentalcar.registerwithapple.RegisterwithApple

// Colores personalizados
val backgroundColor = Color(0xFFE0E0E0)
val cardBackground = Color(0xFF1C1C1C).copy(alpha = 0.85f)
val textColor = Color.White

enum class ButtonState {
    Idle, Loading, Finished
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable
fun PruebaLoginView() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LoginScreen(
            onLoginSuccess = {
                // Acción tras login exitoso
            }
        )
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit
) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var buttonState by remember { mutableStateOf(ButtonState.Idle) }
    val coroutineScope = rememberCoroutineScope()

    val textColor = Color.Black

    // Colores para el modo claro
    val lightGradient = listOf(
        Color(0xFFFFFFFF),
        Color(0xFFE3F2FD),
        Color(0xFFBBDEFB),
        Color(0xFFE3F2FD),
        Color(0xFFFFFFFF)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = androidx.compose.ui.graphics.Brush.radialGradient(
                    colors = lightGradient,
                    center = Offset.Infinite,
                    radius = 1800f
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        // Efecto de desenfoque/blur para el fondo
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = androidx.compose.ui.graphics.Brush.radialGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.White.copy(alpha = 0.2f)
                        ),
                        center = Offset.Infinite,
                        radius = 1000f
                    )
                )
        )

        // Contenido del login
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            LoginLogo()
            Spacer(modifier = Modifier.height(24.dp))
            LoginTitle(textColor)
            Spacer(modifier = Modifier.height(16.dp))

            CustomTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = "Email",
                textColor = textColor
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = "Password",
                visualTransformation = PasswordVisualTransformation(),
                textColor = textColor
            )
            Spacer(modifier = Modifier.height(16.dp))
            LoginButton(
                buttonState = buttonState,
                onClick = {
                    buttonState = ButtonState.Loading
                    coroutineScope.launch {
                        delay(1000)
                        buttonState = ButtonState.Finished
                        onLoginSuccess()
                    }
                }
            )
            Spacer(modifier = Modifier.height(24.dp))
            SocialIcons()
        }
    }
}

@Composable
fun CustomTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    placeholder: String,
    textColor: Color,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(color = textColor),
        visualTransformation = visualTransformation,
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                if (value.text.isEmpty()) {
                    Text(text = placeholder, color = textColor.copy(alpha = 0.5f))
                }
                innerTextField()
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun LoginLogo() {
    Image(
        painter = org.jetbrains.compose.resources.painterResource(resource = Res.drawable.Car),
        contentDescription = null,
        modifier = Modifier
            .size(120.dp)
            .graphicsLayer {
                shadowElevation = 8.dp.toPx()
                shape = CircleShape
                clip = true
            }
    )
}

@Composable
fun LoginTitle(textColor: Color) {
    Text(
        text = "Inicio de Sesion",
        style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Bold,
            color = textColor
        ),
        modifier = Modifier.padding(vertical = 16.dp)
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun LoginButton(
    buttonState: ButtonState,
    onClick: () -> Unit
) {
    // Gradiente que complementa el fondo existente
    val buttonGradient = listOf(
        Color(0xFFE3F2FD),
        Color(0xFFBBDEFB),
        Color(0xFFBBDEFB),
        Color(0xFFBBDEFB),
        Color(0xFFBBDEFB)
    )

    AnimatedVisibility(visible = buttonState == ButtonState.Loading) {
        CircularProgressIndicator(color = Color.White)
    }

    AnimatedVisibility(visible = buttonState != ButtonState.Loading) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .width(267.dp).height(50.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = buttonGradient,
                        start = Offset(0f, 0f),
                        end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                    ),
                    shape = RoundedCornerShape(50)
                )
                .graphicsLayer {
                    shadowElevation = 50.dp.toPx()
                    shape = RoundedCornerShape(50)
                },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            enabled = buttonState != ButtonState.Loading
        ) {
            Text(
                text = when (buttonState) {
                    ButtonState.Finished -> "Bienvenido!"
                    else -> "Iniciar Sesion"
                },
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Composable
fun SocialIcons() {
    RegisterwithApple(texto = "Registrarse con AppleID")
//    Row(
//        horizontalArrangement = Arrangement.SpaceEvenly,
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        listOf(R.drawable.google, R.drawable.apple, R.drawable.facebo).forEach { icon ->
//            Image(
//                painter = painterResource(id = icon),
//                contentDescription = null,
//                modifier = Modifier
//                    .size(48.dp)
//                    .clip(CircleShape)
//                    .background(Color.White.copy(alpha = 0.2f))
//            )
//        }
//    }
}
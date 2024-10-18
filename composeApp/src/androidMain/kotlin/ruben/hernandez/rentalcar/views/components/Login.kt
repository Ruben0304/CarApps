package ruben.hernandez.rentalcar.views.components

import android.graphics.RenderEffect
import android.graphics.Shader
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Login
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
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
import carrental.composeapp.generated.resources.CarDoorBlue
import carrental.composeapp.generated.resources.Phone
import carrental.composeapp.generated.resources.Res
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ruben.hernandez.rentalcar.R

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


@RequiresApi(Build.VERSION_CODES.S)
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
        Color(0xFFD4CBC3),  // Beige medio
        Color(0xFFF5F3F0),  // Beige muy claro
        Color(0xFFE6DFD9),  // Gris beige claro
        Color(0xFFD4CBC3),  // Beige medio
        Color(0xFFE6DFD9),  // Gris beige claro
        Color(0xFFF5F3F0)   // Beige muy claro
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
//    Icon(
//        imageVector = Icons.Filled.DirectionsCar,
//        contentDescription = null,
//        modifier = Modifier
//            .size(120.dp)
//            .graphicsLayer {
//                shadowElevation = 8.dp.toPx()
//                shape = CircleShape
//                clip = true
//            }
//            .clip(CircleShape)
//            .background(Color.Gray),  // Puedes cambiar el color del fondo
//        tint = Color.White // Color del ícono
//    )
}

@Composable
fun LoginTitle(textColor: Color = Color.White) {
    Text(
        text = "Inicio de Sesion",
        style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Bold,
            color = textColor,
            shadow = Shadow(
                color = Color(0xFFD4CBC3), // Color medio de softBeigeGradient
                offset = Offset(2f, 2f),
                blurRadius = 3f
            )
        ),
        modifier = Modifier
            .padding(vertical = 16.dp)
            .graphicsLayer {
                shadowElevation = 8f
                spotShadowColor = Color(0xFFE6DFD9).copy(alpha = 0.5f) // Color claro de softBeigeGradient
                ambientShadowColor = Color(0xFFD4CBC3).copy(alpha = 0.3f) // Color medio de softBeigeGradient
            }
    )
}

// Uso alternativo con parámetros personalizables
@Composable
fun LoginTitle(
    textColor: Color = Color.Black,
    shadowColor: Color = Color(0xFFD4CBC3),
    shadowOffset: Offset = Offset(2f, 2f),
    shadowBlur: Float = 3f
) {
    Text(
        text = "Inicio de Sesion",
        style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Bold,
            color = textColor,
            shadow = Shadow(
                color = shadowColor,
                offset = shadowOffset,
                blurRadius = shadowBlur
            )
        ),
        modifier = Modifier
            .padding(vertical = 16.dp)
            .graphicsLayer {
                shadowElevation = 8f
                spotShadowColor = shadowColor.copy(alpha = 0.5f)
                ambientShadowColor = shadowColor.copy(alpha = 0.3f)
            }
    )
}
//    Column(modifier = Modifier.fillMaxWidth()){
//        Text(
//            text = "Ingresar Credenciales",
//            color = Color.Black,
//            style = MaterialTheme.typography.titleLarge.copy(
//                shadow = Shadow(
//                    color = Color(0xFFBBDEFB),
//                    offset = Offset(3f,3f),
//                    blurRadius = 0f
//                )
//            )
//        )


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun LoginButton(
    buttonState: ButtonState,
    onClick: () -> Unit
) {
    Column(Modifier.padding(20.dp)) {
        AnimatedVisibility(visible = buttonState == ButtonState.Loading) {
            CircularProgressIndicator(color = Color.White)
        }

        AnimatedVisibility(visible = buttonState != ButtonState.Loading) {
            BotonColor(
                icono = org.jetbrains.compose.resources.painterResource(resource = Res.drawable.Phone),
                colorSombra = Color.Black,
                onClick = onClick,
                modifier = Modifier
                    .width(267.dp)
                    .height(50.dp),
                enabled = buttonState != ButtonState.Loading,
                text = when (buttonState) {
                    ButtonState.Finished -> "Bienvenido!"
                    else -> "Iniciar Sesion"
                },
                textStyle = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Composable
fun BotonColor(
    icono: Painter,
    colorSombra: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    textStyle: TextStyle
) {
    Button(
        onClick = onClick,
        modifier = modifier.graphicsLayer {
            shadowElevation = 50.dp.toPx()
            shape = RoundedCornerShape(50)
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        ),
        enabled = enabled
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(painter = icono, contentDescription = null)
            Text(
                text = text,
                style = textStyle
            )
        }
    }
}

//@Composable
//fun LoginButton(
//    buttonState: ButtonState,
//    onClick: () -> Unit
//) {
//    // Gradiente aplicado al fondo del botón
//    val buttonGradient = Brush.linearGradient(
//        colors = listOf(
//            Color(0xFFE3F2FD),
//            Color(0xFFBBDEFB),
//            Color(0xFFBBDEFB),
//            Color(0xFFBBDEFB),
//            Color(0xFFBBDEFB)
//        ),
//        start = Offset(0f, 0f),
//        end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
//    )
//
//    // Botón FAB extendido con animaciones
//    AnimatedVisibility(visible = buttonState != ButtonState.Loading) {
//        ExtendedFloatingActionButton(
//            text = {
//                Text(
//                    text = when (buttonState) {
//                        ButtonState.Finished -> "Bienvenido!"
//                        else -> "Iniciar Sesión"
//                    },
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 18.sp
//                )
//            },
//            onClick = onClick,
//            modifier = Modifier
//                .width(267.dp)
//                .height(50.dp)
//                .clip(RoundedCornerShape(50))
//                .background(buttonGradient)
//                .graphicsLayer {
//                    shadowElevation = 16.dp.toPx()
//                    shape = RoundedCornerShape(50)
//                    clip = true
//                },
//            elevation = FloatingActionButtonDefaults.elevation(16.dp),
//            icon = {
//                Icon(
//                    imageVector = Icons.Default.Login,
//                    contentDescription = "Login Icon"
//                )
//            }
//        )
//    }
//
//    // Indicador de carga cuando el estado es ButtonState.Loading
//    AnimatedVisibility(visible = buttonState == ButtonState.Loading) {
//        CircularProgressIndicator(
//            color = Color.White,
//            modifier = Modifier.size(50.dp)
//        )
//    }
//}
//@Composable
//fun LoginButton() {
//    Column(Modifier.padding(20.dp)) {
//        BotonColor(
//            icono = org.jetbrains.compose.resources.painterResource(resource = Res.drawable.Phone),
//            colorSombra = Color.Black
//        )
//    }
//}

@Composable
fun SocialIcons() {
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
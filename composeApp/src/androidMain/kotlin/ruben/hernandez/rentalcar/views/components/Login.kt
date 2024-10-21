package ruben.hernandez.rentalcar.views.components

import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
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
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.Car
import carrental.composeapp.generated.resources.CarDoorBlue
import carrental.composeapp.generated.resources.Facebook
import carrental.composeapp.generated.resources.Phone
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.Shape
import carrental.composeapp.generated.resources.Wrapper
import carrental.composeapp.generated.resources.profile
import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.R
import ruben.hernandez.rentalcar.views.poppinsFontFamily

// Colores personalizados
val backgroundColor = Color(0xFFE0E0E0)
val cardBackground = Color(0xFF1C1C1C).copy(alpha = 0.85f)
val textColor = Color.White

enum class ButtonState {
    Idle, Loading, Finished
}

@Composable
fun CustomTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    placeholder: String,
    textColor: Color,
    isPassword: Boolean = false,
    showForgotPassword: Boolean = false,
    modifier: Modifier = Modifier
) {
    var passwordVisible by remember { mutableStateOf(false) }

    Column {
        Surface(
            color = Color.White,
            shape = RoundedCornerShape(25.dp),
            shadowElevation = 0.dp,
            modifier = modifier
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = TextStyle(color = textColor, textDecoration = TextDecoration.None),
                visualTransformation = if (isPassword && !passwordVisible)
                    PasswordVisualTransformation() else VisualTransformation.None,
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))

                            .padding(16.dp)
                    ) {
                        if (value.text.isEmpty()) {
                            Text(text = placeholder, color = textColor.copy(alpha = 0.5f))
                        }
                        Box(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            innerTextField()
                            if (isPassword) {
                                IconButton(
                                    onClick = { passwordVisible = !passwordVisible },
                                    modifier = Modifier
                                        .align(Alignment.CenterEnd)
                                        .size(18.dp)
//                                        .offset(x = 3.dp)
                                ) {
                                    Icon(
                                        imageVector = if (passwordVisible)
                                            Icons.Default.Visibility
                                        else
                                            Icons.Default.VisibilityOff,
                                        contentDescription = if (passwordVisible)
                                            "Ocultar contraseña"
                                        else
                                            "Mostrar contraseña",
                                        tint = textColor,

                                        )
                                }
                            }
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun ForgotPassword(modifier: Modifier = Modifier) {
    Text(
        text = "¿Olvidaste tu contraseña 🤔?",
        color = Color(14, 13, 13, 255),
        fontSize = 13.sp,

        fontFamily = poppinsFontFamily,
        modifier = modifier
            .clickable {
                // TODO: Implementar funcionalidad de recuperación de contraseña
                // Aquí iría la lógica para manejar el olvido de contraseña
            }
    )
}


@Composable
fun LoginLogo() {
    Image(
        painter = org.jetbrains.compose.resources.painterResource(resource = Res.drawable.profile),
        contentDescription = null,
        modifier = Modifier
            .size(120.dp)
            .graphicsLayer {
                shadowElevation = 8.dp.toPx()
                shape = CircleShape
            }
            .border(
                BorderStroke(
                    3.dp, brush = Brush.horizontalGradient(
                        listOf(
                            Color(
                                135,
                                178,
                                240,
                                255
                            ), Color(
                                222,
                                161,
                                226,
                                255
                            )
                        )
                    )
                ), shape = CircleShape
            )
    )
}

@Composable
fun LoginTitle() {
    Text(
        text = "Iniciar sesión",
        color = Color(32, 32, 32, 255),
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun LoginButton(
    buttonState: ButtonState,
    onClick: () -> Unit
) {
    Box(Modifier.padding(20.dp)) {


            Box(
                modifier = Modifier
                    .width(240.dp)
                    .height(55.dp)
                    .padding(horizontal = 15.dp)
            ) {
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(
                            color = Color.Black,
                            shape = RoundedCornerShape(80)
                        )
                )
                Button(
                    onClick = onClick,
                    modifier = Modifier
                        .fillMaxSize(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.White
                    ),
                    elevation = ButtonDefaults.elevatedButtonElevation(12.dp),
                    enabled = buttonState != ButtonState.Loading
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
//                            .padding(vertical = 4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        androidx.compose.animation.AnimatedVisibility(visible = buttonState == ButtonState.Loading) {
                            CircularProgressIndicator(
                                color = Color.White, strokeWidth = 4.dp, modifier = Modifier.size(20.dp)

                            )
                        }
                        Text(
                            text = when (buttonState) {
                                ButtonState.Finished -> "Bienvenido!"
                                ButtonState.Loading -> ""
                                else -> "Confirmar"
                            },
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = poppinsFontFamily
                        )
                    }
                }
            }

    }
}

@Composable
fun SocialIcons(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        listOf(Res.drawable.Wrapper, Res.drawable.Shape, Res.drawable.Facebook).forEach { icon ->
            Surface(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .size(70.dp),
                shadowElevation = 8.dp,
                color = Color.White,
                shape = CircleShape


            ) {

                Image(
                    painter = org.jetbrains.compose.resources.painterResource(resource = icon),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                )
//


            }
        }
    }
}
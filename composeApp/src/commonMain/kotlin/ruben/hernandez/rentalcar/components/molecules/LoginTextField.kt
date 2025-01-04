package ruben.hernandez.rentalcar.components.molecules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

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
//                                    Icon(
//                                        imageVector = if (passwordVisible)
//                                            Icons.Default.Visibility
//                                        else
//                                            Icons.Default.VisibilityOff,
//                                        contentDescription = if (passwordVisible)
//                                            "Ocultar contraseña"
//                                        else
//                                            "Mostrar contraseña",
//                                        tint = textColor,
//
//                                        )
                                }
                            }
                        }
                    }
                }
            )
        }
    }
}
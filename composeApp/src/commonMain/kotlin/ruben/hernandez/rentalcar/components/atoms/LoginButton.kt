package ruben.hernandez.rentalcar.components.atoms

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.viewModels.Chat.Auth.ButtonState

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
                    .background(brush = Brush.horizontalGradient(
                        listOf(
                            Color(128, 120, 247, 255),
                            Color(88, 133, 243, 255)
                        )
                    ),shape = RoundedCornerShape(80)
                    )
            )
            Button(
                onClick = onClick,
                modifier = Modifier
                    .fillMaxSize(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = AppColors.cardsBackground
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
                            color = AppColors.cardsBackground, strokeWidth = 4.dp, modifier = Modifier.size(20.dp)

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
                        color = Color.White
                    )
                }
            }
        }

    }
}
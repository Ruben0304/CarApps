package ruben.hernandez.rentalcar.views.components.home

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.Part3D
import carrental.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors

@Composable
fun ModernHomeCard(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit,
    image: Painter,
    color: Color,
    text: String,
    buttonText: String
) {
        Card(
            modifier = modifier
                .shadow(12.dp, spotColor = color, shape = RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = AppColors.cardsBackground
            ),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 20.dp, horizontal = 10.dp)
                    .background(
                        brush = Brush.radialGradient(
                            listOf(
                                color.copy(.42f),
                                AppColors.cardsBackground
                            )
                        ),
                    )
            ) {
                Text(
                    text = text,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal,
                    color = AppColors.text,
                    lineHeight = 25.sp,
                    modifier = Modifier.align(Alignment.TopCenter)

                )

                Image(
                    painter = image,
                    contentDescription = "Brake disc illustration",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxHeight(.5f)
                )

                Button(
                    onClick = onButtonClick,
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth(.85f)
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(
                                    color,
                                    color
                                )
                            ), shape = RoundedCornerShape(14.dp)
                        )
                        .clip(RoundedCornerShape(14.dp))
                        .align(Alignment.BottomCenter),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                        Text(
                            text = buttonText,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )

                }
            }
        }




}

package ruben.hernandez.rentalcar.views.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.Ajustes
import carrental.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors

@Composable
fun ModernMechanicCard(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit,
    image: Painter,
    color: Color,
    text: String,
    buttonText: String
) {
    Card(
        modifier = modifier
            .shadow(6.dp, spotColor = color.copy(.35f), shape = RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Background Image with blur effect
            Image(
                painter = painterResource(resource = Res.drawable.Ajustes),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .blur(2.dp),
                contentScale = ContentScale.Crop
            )

            // Gradient Overlay with increased opacity
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                AppColors.cardsBackground.copy(alpha = 0.8f),
                                AppColors.cardsBackground.copy(.85f),
                                Color.Black.copy(.9f)
                            )
                        )
                    )
            )

            // Content
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 20.dp, horizontal = 10.dp)
            ) {
                Column(
                    Modifier
                        .align(Alignment.TopStart)
                        .padding(start = 10.dp)) {
                    Text(
                        text = text,
                        fontSize = 21.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = AppColors.text,


                    )
                    Spacer(modifier = Modifier.height(22.dp))
                    Text(
                        text = text,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        color = AppColors.text.copy(.8f),
                        lineHeight = 25.sp,
                    )
                }


                Button(
                    onClick = onButtonClick,
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth(.35f)
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(
                                    color,
                                    color
                                )
                            ),
                            shape = RoundedCornerShape(14.dp)
                        )
                        .clip(RoundedCornerShape(14.dp))
                        .align(Alignment.BottomEnd),
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




}
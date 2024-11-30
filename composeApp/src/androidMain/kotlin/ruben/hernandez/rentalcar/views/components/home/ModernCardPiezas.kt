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
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.Part3D
import carrental.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors

@Composable
fun ModernCardPiezas(modifier: Modifier = Modifier, onSearchClick: () -> Unit) {

    Box(modifier = modifier) {
        Card(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize(.75f),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.radialGradient(
                            listOf(
                                AppColors.principal.copy(.35f),
                                AppColors.cardsBackground.copy()
                            )
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ),
            ) {
                Text(
                    text = "Encuentra la pieza\nque necesitas",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = AppColors.text,
                    lineHeight = 25.sp,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 10.dp)

                )

                Button(
                    onClick = onSearchClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppColors.principal
                    ),

                    contentPadding = PaddingValues(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    modifier = Modifier
                        .height(55.dp)
                        .fillMaxWidth(.45f)
                        .padding(bottom = 20.dp, end = 20.dp)
                        .align(Alignment.BottomEnd),
                    elevation = ButtonDefaults.buttonElevation(12.dp)

                ) {
                    Text(
                        text = "Buscar",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
            }
        }
        Image(
            painter = painterResource(resource = Res.drawable.Part3D),
            contentDescription = "Brake disc illustration",
            modifier = Modifier
                .fillMaxWidth(.48f)
                .align(Alignment.BottomStart)
        )
    }


}

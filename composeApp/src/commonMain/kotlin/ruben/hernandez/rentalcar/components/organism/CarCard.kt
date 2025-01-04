package ruben.hernandez.rentalcar.components.organism

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.Gearbox
import carrental.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.views.components.common.LikeButton

@Composable
fun CarCard(
    carName: String,
    carType: String,
    imageUrl: String,
    passengers: Int,
    transmission: String,
    pricePerDay: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(18.dp),
        shadowElevation = 6.dp,
        modifier = modifier,
        color = AppColors.cardsBackground,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Título y tipo de coche
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = carName,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = AppColors.text
                    )
                    Text(
                        text = carType,
                        fontSize = 14.sp,
                        color = Color.Gray,
                    )
                }

                LikeButton {

                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            // Cargar imagen con Coil

//            Image(
//                painter = rememberAsyncImagePainter(model = imageUrl),
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(150.dp),
//                contentScale = ContentScale.Fit
//            )

            Spacer(modifier = Modifier.height(8.dp))


            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
//                Icon(
//                    imageVector = Icons.Filled.WbSunny,
//                    contentDescription = null,
//                    tint = Color.Gray,
//                    modifier = Modifier.size(20.dp)
//                )
                Text(
                    text = "$passengers",
                    modifier = Modifier.padding(start = 4.dp, end = 16.dp),
                    fontSize = 14.sp,
                    color = AppColors.text
                )

                Icon(
                    painter = painterResource(resource = Res.drawable.Gearbox),
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = transmission,
                    modifier = Modifier.padding(start = 4.dp),
                    fontSize = 14.sp,
                    color = AppColors.text
                )
                Spacer(modifier = Modifier.weight(1f))

                // Precio por día
                Text(
                    text = pricePerDay,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End,
                    color = AppColors.text
                )
            }
        }


    }
}
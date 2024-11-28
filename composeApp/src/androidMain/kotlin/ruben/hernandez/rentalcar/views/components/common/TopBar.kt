package ruben.hernandez.rentalcar.views.components.common

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.views.poppinsFontFamily

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun TopBar(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {


                Text(
                    "Ubicación",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontFamily = poppinsFontFamily,


                )
                    Text(
                        "Playa, La Habana",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = poppinsFontFamily,
                        color = AppColors.text,
                        )

            }

            Spacer(modifier = Modifier.weight(1f))

            Row(
                horizontalArrangement = Arrangement.spacedBy(13.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ButtonSearch(
                    modifier = Modifier.size(42.dp),
                    onClick = { }
                )

//                ButtonProfile(
//                    modifier = Modifier.height(42.dp),
//                    onClick = onClick
//                )
            }
        }

}

//icons como histories de ig
//            Image(
//                painter = rememberAsyncImagePainter(
//                    ImageRequest.Builder(LocalContext.current)
//                        .data(data = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSx_HPjBBKzO2_jwe1dSfxMoTwNrTTEFMa3YmrBZCo5bh5S0jXPWfcRAcmKBe4pP1wmgyY&usqp=CAU")
//                        .apply(block = fun ImageRequest.Builder.() {
//                            crossfade(true)
//                        }).build()
//                ),
//                contentDescription = "Notification Picture",
//                modifier = Modifier
//                    .size(40.dp)
//                    .clip(CircleShape)
//                    .border(1.5.dp, Color.LightGray, shape = CircleShape),
//                contentScale = ContentScale.FillBounds
//            )

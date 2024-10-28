package ruben.hernandez.rentalcar.views.components.common

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.MapMarker
import carrental.composeapp.generated.resources.PlaceMarker
import carrental.composeapp.generated.resources.Res
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.views.poppinsFontFamily


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun TopBar(onClick: () -> Unit,modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Ubicación Icon",
                        modifier = Modifier.size(18.dp),
                        tint = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(1.dp))
                    Text(
                        "Ubicación",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontFamily = poppinsFontFamily
                    )
                }
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    "Playa, La Habana!",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFontFamily,
                    color = AppColors.dark
                )

            }

            Spacer(modifier = Modifier.weight(1f))
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
            Spacer(modifier = Modifier.width(15.dp))
            ButtonProfile(
                modifier = Modifier,
                onClick = onClick
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchInput(
                modifier = Modifier
                    .weight(1f)
                    .height(42.dp)
            )

            MapButton(
                onClick = { },
                modifier = Modifier.size(42.dp),
                icono = painterResource(resource = Res.drawable.PlaceMarker),
                )
        }
    }
}

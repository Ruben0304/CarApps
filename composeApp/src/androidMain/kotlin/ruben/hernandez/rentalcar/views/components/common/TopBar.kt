package ruben.hernandez.rentalcar.views.components.common

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.viewModels.Auth.LoginViewModel
import ruben.hernandez.rentalcar.views.poppinsFontFamily
import ruben.hernandez.rentalcar.views.screens.Auth.LoginScreen


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun TopBar(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp, top = 22.dp, start = 20.dp, end = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text("Ubicación", fontSize = 14.sp, color = Color.LightGray, fontFamily = poppinsFontFamily)
            Text("Havana, Cuba", fontSize = 18.sp, fontWeight = FontWeight.Bold,fontFamily = poppinsFontFamily, color = AppColors.dark)
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSx_HPjBBKzO2_jwe1dSfxMoTwNrTTEFMa3YmrBZCo5bh5S0jXPWfcRAcmKBe4pP1wmgyY&usqp=CAU")
                    .apply(block = fun ImageRequest.Builder.() {
                        crossfade(true)
                    }).build()
            ),
            contentDescription = "Notification Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, Color.LightGray, shape = CircleShape),
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.width(15.dp))
        ButtonProfile(
            modifier = Modifier,
           onClick = onClick
        )

    }
}

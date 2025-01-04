package ruben.hernandez.rentalcar.components.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class CarBrand(val name: String, val imageUrl: String)

@Composable
fun CarBrandItem(carBrand: CarBrand) {
    Column(
        modifier = Modifier
            .width(90.dp)
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen circular
        Surface(
//            border = BorderStroke(1.5.dp, AppColors.dark),
            shadowElevation = 12.dp,
            modifier = Modifier
                .size(65.dp),
            shape = CircleShape,
            color = Color.LightGray // Color de fondo por si tarda en cargar la imagen
        ) {
//            Image(
//                painter = rememberAsyncImagePainter(model = carBrand.imageUrl),
//                contentDescription = carBrand.name,
//                modifier = Modifier
//                    .fillMaxSize(),
//                contentScale = ContentScale.Crop
//            )
        }
        Spacer(modifier = Modifier.height(5.dp))

        // Nombre de la marca
        Text(
            text = carBrand.name,
            modifier = Modifier.padding(top = 8.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
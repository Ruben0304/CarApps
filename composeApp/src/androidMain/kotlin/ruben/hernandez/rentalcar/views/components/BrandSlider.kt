package ruben.hernandez.rentalcar.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import coil.compose.rememberAsyncImagePainter
import ruben.hernandez.rentalcar.views.poppinsFontFamily

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MaterialTheme {
//                HorizontalCarBrandList(
//                    carBrands = listOf(
//                        CarBrand("Audi", "https://upload.wikimedia.org/wikipedia/commons/a/ae/Logo_audi.jpg"),
//                        CarBrand("BMW", "https://logodownload.org/wp-content/uploads/2014/04/bmw-logo-1.png"),
//                        CarBrand("Mercedes", "https://logodownload.org/wp-content/uploads/2014/09/mercedes-benz-logo-0.png"),
//                        CarBrand("Tesla", "https://logodownload.org/wp-content/uploads/2014/09/tesla-logo-2-1.png")
//                    )
//                )
//            }
//        }
//    }
//}

data class CarBrand(val name: String, val imageUrl: String)

@Composable
fun HorizontalCarBrandList(carBrands: List<CarBrand>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.spacedBy(1.dp),
        contentPadding = PaddingValues( horizontal = 7.dp,vertical = 15.dp)
    ) {
        items(carBrands) { carBrand ->
            CarBrandItem(carBrand)
        }
        
    }
}

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
//            Image(painter = org.jetbrains.compose.resources.painterResource(resource = Res.drawable.whatsapp_playstore) , contentDescription = "")
            Image(
                painter = rememberAsyncImagePainter(model = carBrand.imageUrl),
                contentDescription = carBrand.name,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(5.dp))

        // Nombre de la marca
        Text(
            text = carBrand.name,
            modifier = Modifier.padding(top = 8.dp),
            fontSize = 15.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.SemiBold
        )
    }
}

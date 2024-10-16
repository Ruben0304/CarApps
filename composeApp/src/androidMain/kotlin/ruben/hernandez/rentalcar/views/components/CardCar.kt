package ruben.hernandez.rentalcar.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.ui.tooling.preview.Preview
import carrental.composeapp.generated.resources.Gearbox
import carrental.composeapp.generated.resources.Res
import coil.compose.rememberAsyncImagePainter
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.views.poppinsFontFamily


@Composable
fun CarCard(
    carName: String,
    carType: String,
    imageUrl: String,
    passengers: Int,
    transmission: String,
    pricePerDay: String,
    onClick: ()-> Unit = {}
) {
    Surface(
        shape = RoundedCornerShape(18.dp),
        shadowElevation = 6.dp,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        color = Color.White
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
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = carType,
                        fontSize = 14.sp,
                        fontFamily = poppinsFontFamily,
                        color = Color.Gray
                    )
                }

                // Icono de "me gusta"
                IconButton(onClick = { /* Acción */ }) {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Favorite",
                        tint = Color.Red
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            // Cargar imagen con Coil

            Image(
                painter = rememberAsyncImagePainter(model = imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(8.dp))

            
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.WbSunny,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "$passengers",
                    modifier = Modifier.padding(start = 4.dp, end = 16.dp),
                    fontFamily = poppinsFontFamily,
                    fontSize = 14.sp
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
                    fontFamily = poppinsFontFamily,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.weight(1f))

                // Precio por día
                Text(
                    text = pricePerDay,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFontFamily,
                    textAlign = TextAlign.End
                )
            }
            }


            
        }
    }


@Composable
fun CarList() {
    LazyColumn{
        // Lista de coches (puedes añadir más elementos aquí)
        items(1) { index ->
            CarCard(
                carName = "Porsche 718 Cayma",
                carType = "Coupe",
                imageUrl = "https://pngimg.com/d/maserati_PNG28.png",
                passengers = 2,
                transmission = "Manual",
                pricePerDay = "$400/d"
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CarList()
}

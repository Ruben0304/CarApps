package ruben.hernandez.rentalcar.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import carrental.composeapp.generated.resources.Account
import carrental.composeapp.generated.resources.CarDoorBlue
import carrental.composeapp.generated.resources.FlightSeatBlue
import carrental.composeapp.generated.resources.GasStationBlue
import carrental.composeapp.generated.resources.GearboxBlue
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.SnowflakeBlue
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.views.poppinsFontFamily


@Preview
@Composable
fun Preview() {

    val carSpecs = listOf(
        CarSpecs("Maxima Potencia", "320", "ph"),
        CarSpecs("0-60 mph", "4.4", "segundos"),
        CarSpecs("Maxima Velocidad", "177", "mph")
    )

    val imgs = listOf(
        "https://www.automachi.com/wp-content/uploads/2021/08/Untitled-1-3.jpg",
        "https://wallup.net/wp-content/uploads/2019/09/345133-bmw-i8-car-hybrib-future-4000x3000-748x561.jpg",
        "https://gossipvehiculo.com/wp-content/uploads/2022/03/toyota-2-1024x526.png"
    )

    CardCarInfo(
        carName = "Porsche 718 Cayma",
        carType = "Coupe",
        imagenesUrl = imgs,
        passengers = 2,
        transmission = "Manual",
        pricePerDay = "$400",
        carSpecsList = carSpecs,
        doors = 2,
        airConditioning = true,
        fuelCapacity = 40,
        confortable = true,
    )
}


@Composable
fun CardCarInfo(
    carName: String,
    carType: String,
    imagenesUrl: List<String>,
    passengers: Int,
    transmission: String,
    pricePerDay: String,
    carSpecsList: List<CarSpecs>,
    doors: Int,
    airConditioning: Boolean,
    fuelCapacity: Int,
    confortable: Boolean,
    navController: NavController = rememberNavController()

) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
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

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.height(200.dp)
            ) {
                carouselImage(imagenesUrl)
            }

            Spacer(modifier = Modifier.height(10.dp))


            Text(
                text = "Especificaciones",
                fontSize = 20.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(10.dp))

            // espesificaciones del carro
            LazyRow(Modifier.padding()) {
                items(carSpecsList) { item ->
                    cardCarSpecs(item)
                }
            }

            Spacer(modifier = Modifier.height(5.dp))


            Text(
                text = "Informacion Del Carro",
                fontSize = 20.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
            )


            carInfoSeccion(
                passengers,
                transmission,
                doors,
                airConditioning,
                fuelCapacity,
                confortable,
                recurso1 = painterResource(Res.drawable.CarDoorBlue),
                recurso2 = painterResource(Res.drawable.Account),
                recurso3 = painterResource(Res.drawable.GearboxBlue),
                recurso4 = painterResource(Res.drawable.SnowflakeBlue),
                recurso5 = painterResource(Res.drawable.GasStationBlue),
                recurso6 = painterResource(Res.drawable.FlightSeatBlue),
                textStyle = 16.sp,
                modifierCuerpo = Modifier.padding(top = 10.dp),
                modifierIcon = Modifier.size(20.dp)

            )
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(

                ) {
                    Text(
                        text = "Total",
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(7.dp))

                    Row {
                        Text(
                            text = pricePerDay,
                            fontSize = 20.sp,
                            fontFamily = poppinsFontFamily,
                            color = Color.Black
                        )
                        Text(
                            text = "/d",
                            fontSize = 20.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                    }

                }

                BackButton(onClick = { navController.popBackStack() })
            }

        }
    }
}


data class CarSpecs(
    val specsName: String,
    val specsValue: String,
    val specsUnit: String
)


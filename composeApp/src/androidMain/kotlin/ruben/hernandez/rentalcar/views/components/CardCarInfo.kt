package ruben.hernandez.rentalcar.views.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import carrental.composeapp.generated.resources.Account
import carrental.composeapp.generated.resources.CarDoorBlue
import carrental.composeapp.generated.resources.Close
import carrental.composeapp.generated.resources.FlightSeatBlue
import carrental.composeapp.generated.resources.GasStationBlue
import carrental.composeapp.generated.resources.GearboxBlue
import carrental.composeapp.generated.resources.Phone
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.SnowflakeBlue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.views.poppinsFontFamily


@OptIn(ExperimentalMaterialApi::class)
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

@OptIn(ExperimentalMaterialApi::class)
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
    navController: NavController = rememberNavController(),
    isOpened: Boolean = false,
    initialLoading: Boolean = true,
    sheetState: BottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
) {
    var isLoading by remember { mutableStateOf(initialLoading) }
    val corrutineScope = rememberCoroutineScope()

    LaunchedEffect(isOpened) {
        delay(3000)
        isLoading = false
    }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        if (isLoading) {
            // Vista de loading con CircularProgressIndicator
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.8f)
            ) {
                CircularProgressIndicator(
                    strokeWidth = 7.dp,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(50.dp),
                    color = AppColors.principal
                )
            }
        } else {
            // Contenido después del loading con animaciones elegantes
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .fillMaxWidth()
            ) {
                // Animación del título y tipo de coche
                AnimatedVisibility(
                    visible = !isLoading,
                    enter = slideInVertically(initialOffsetY = { -1000 }, animationSpec = tween(800)) + fadeIn(animationSpec = tween(1000, delayMillis = 200))
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = carName,
                            fontSize = 17.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Bold,
                        )
                       IconButton(onClick = { corrutineScope.launch { sheetState.collapse() }}, modifier = Modifier.size(20.dp)) {
                           Icon(painter = painterResource(resource = Res.drawable.Close), contentDescription = "close button", modifier= Modifier.fillMaxSize())
                       }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Animación de la imagen del coche
                AnimatedVisibility(
                    visible = !isLoading,
                    enter = slideInVertically(initialOffsetY = { -1000 }, animationSpec = tween(900)) + fadeIn(animationSpec = tween(900, delayMillis = 400))
                ) {
                    Row(
                        modifier = Modifier.height(200.dp)
                    ) {
                        CarouselImage(
                            imagenesUrl,
                            modifier = Modifier.padding(top = 0.dp, bottom = 0.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

                // Especificaciones del coche con Fade y Slide
                Text(
                    text = "Especificaciones",
                    fontSize = 18.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(Modifier.padding()) {
                    items(carSpecsList) { item ->
                        AnimatedVisibility(
                            visible = !isLoading,
                            enter = slideInVertically(initialOffsetY = { -800 }, animationSpec = tween(700)) + fadeIn(animationSpec = tween(700, delayMillis = 500))
                        ) {
                            CardCarSpecs(item)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))

                // Información adicional del coche
                AnimatedVisibility(
                    visible = !isLoading,
                    enter = slideInVertically(initialOffsetY = { -700 }, animationSpec = tween(800)) + fadeIn(animationSpec = tween(800, delayMillis = 600))
                ) {
                    Text(
                        text = "Información Del Carro",
                        fontSize = 17.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                AnimatedVisibility(
                    visible = !isLoading,
                    enter = slideInVertically(initialOffsetY = { -600 }, animationSpec = tween(900)) + fadeIn(animationSpec = tween(900, delayMillis = 700))
                ) {
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
                }
            }

            // Precio y botón "Contactar" con animación
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(start = 40.dp, bottom = 30.dp)
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
                        fontWeight = FontWeight.Bold,
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

            // Botón de contacto con animación

                BotonColor(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(160.dp, 80.dp)
                        .padding(bottom = 30.dp, end = 20.dp),
                    icono = painterResource(resource = Res.drawable.Phone),
                    texto = "Contactar",
                    tamanoTexto = 14.sp,
                    colorSombra = Color.Blue,
                    tamanoIcono = 15.dp
                )

        }

    }

}


data class CarSpecs(
    val specsName: String,
    val specsValue: String,
    val specsUnit: String
)


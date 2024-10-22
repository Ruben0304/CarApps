import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import ruben.hernandez.rentalcar.views.components.car.CarSpecs
import ruben.hernandez.rentalcar.views.components.car.CardCarInfo
import ruben.hernandez.rentalcar.views.components.common.MenuDeslizable


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SheetContent(sheetState: BottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)) {
    val carSpecs = listOf(
        CarSpecs("Max. Potencia", "320", "ph"),
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
        sheetState = sheetState
    )
}


@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun PreviewMenuDeslizable() {
//    var isOpenButtomShet by remember { mutableStateOf(false) }

    val corrutineScope = rememberCoroutineScope()
    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed,
        animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing)
    )


    MenuDeslizable(
        { SheetContent() },
        sheetState
    )

    androidx.compose.material3.Button(onClick = {
        corrutineScope.launch {
            sheetState.expand()
        }
    }) {
        Text("pincha cojone")
    }
}


package ruben.hernandez.rentalcar.components.molecules

import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import ruben.hernandez.rentalcar.components.organism.CarSpecs
import ruben.hernandez.rentalcar.components.organism.CardCarInfo

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
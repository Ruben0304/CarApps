import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetDefaults
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ruben.hernandez.rentalcar.views.components.CarDetailContent
import ruben.hernandez.rentalcar.views.components.CarSpecs
import ruben.hernandez.rentalcar.views.components.CardCarInfo


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuDeslizable(
    sheetContent: @Composable () -> Unit,
    sheetState: BottomSheetState,
    parentContent: @Composable () -> Unit = {},
    topPadding: Dp = 110.dp
) {

    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = sheetState)
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val screenHeight = maxHeight


        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetGesturesEnabled = true,
            sheetContent = {
                Column {
                    Spacer(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .width(40.dp)
                            .height(4.dp)
                            .background(Color.LightGray)
                            .align(Alignment.CenterHorizontally)
                    )
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(screenHeight - topPadding)
                    ) {
                        sheetContent()
                    }
                }
            },
            sheetPeekHeight = 0.dp,
            sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
        ) {
            parentContent()
        }

    }
}

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


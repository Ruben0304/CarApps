package ruben.hernandez.rentalcar.views.components.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.ResizeIndicator
import org.jetbrains.compose.resources.painterResource

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
                    Image(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .width(40.dp)
                            .height(4.dp)

                            .align(Alignment.CenterHorizontally),
                        painter = painterResource(resource = Res.drawable.ResizeIndicator),
                        contentDescription = ""
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

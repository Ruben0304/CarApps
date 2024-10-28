package ruben.hernandez.rentalcar.views.components.common

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild
import kotlinx.coroutines.launch
import ruben.hernandez.rentalcar.views.components.car.CarCard


@RequiresApi(Build.VERSION_CODES.S)
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Glass(){
    val hazeState = remember { HazeState() }

    Box {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                // Pass it the HazeState we stored above
                .haze(state = hazeState)
        ) {
            items(5) { index ->

                CarCard(
                    carName = "Porsche 718 Cayman S",
                    carType = "Coupe",
                    imageUrl = "https://pngimg.com/d/maserati_PNG28.png",
                    passengers = 2,
                    transmission = "Manual",
                    pricePerDay = "$400/d",

                    )

            }
        }

        TopAppBar(
            // Need to make app bar transparent to see the content behind
            colors = TopAppBarDefaults.largeTopAppBarColors(Color.Transparent),
            modifier = Modifier
                // We use hazeChild on anything where we want the background
                // blurred.
                .hazeChild(state = hazeState)
                .height(85.dp)
                .fillMaxWidth(),
            title = {TopBar(onClick = {
            })},
        )
    }

}

package ruben.hernandez.rentalcar.views.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.components.organism.CarCard
import ruben.hernandez.rentalcar.views.components.common.BackButton
import ruben.hernandez.rentalcar.views.components.common.SearchInput
import ruben.hernandez.rentalcar.views.components.piezas.MechanicPartCard
import ruben.hernandez.rentalcar.views.components.search.TopNavButton

@OptIn(ExperimentalMaterial3Api::class, ExperimentalHazeMaterialsApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun SearchScreen(navController: NavController = rememberNavController(), generic: Boolean = true) {
    var selectedButton by remember { mutableStateOf(0) }
    var listado by remember { mutableStateOf(ListTypes.Auto) }
    val hazeState = remember { HazeState() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(AppColors.backgroundGradient))
    ) {

//        var visible by remember { mutableStateOf(false) }
//        val alpha by animateFloatAsState(
//            targetValue = if (visible) 1f else 0f,
//            animationSpec = tween(durationMillis = 1000)
//        )



        when (listado) {
            ListTypes.Auto -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .haze(state = hazeState),
                    verticalArrangement = Arrangement.spacedBy(40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    item{
                        Spacer(modifier = Modifier.height(105.dp))
                    }
                    items(5) { index ->
//                        LaunchedEffect(key1 = true) {
//                            delay(150L * index) // Retraso escalonado para cada card
//                            visible = true
//                        }
//                        Box(modifier = Modifier.alpha(alpha)) {
                            CarCard(
                                carName = "Porsche 718 Cayman",
                                carType = "Coupe",
                                imageUrl = "https://pngimg.com/d/maserati_PNG28.png",
                                passengers = 2,
                                transmission = "Manual",
                                pricePerDay = "$400/d",
                                modifier = Modifier.fillMaxWidth(.9f)
                            )
//                        }
                    }
                }
            }
            ListTypes.Pieza -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(15.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier
                        .fillMaxSize().padding(12.dp)
                        .haze(state = hazeState)
                ) {
                    item{
                        Spacer(modifier = Modifier.height(120.dp))
                    }
                    item{
                        Spacer(modifier = Modifier.height(120.dp))
                    }
                    // Lista de coches (puedes añadir más elementos aquí)
                    items(12) { // ejemplo con 5 elementos
                        MechanicPartCard(
                            name = "Porsche 718 Cayman",
                            partType = "Habana",
                            imageUrl = "https://pngimg.com/d/engine_PNG20.png", // URL de la imagen
                            isFavorite = false,
                            onFavoriteClick = {},
                            price = "$400",
                            modifier = Modifier.height(270.dp).width(100.dp)
                        )
                    }

                }
            }

            else -> {}
        }
        TopAppBar(
            // Need to make app bar transparent to see the content behind
            colors = TopAppBarDefaults.largeTopAppBarColors(Color.Transparent),
            modifier = Modifier
                // We use hazeChild on anything where we want the background
                // blurred.
                .hazeChild(
                    state = hazeState,
                    style = HazeMaterials.ultraThin(),
                )
                .height(135.dp)
                .fillMaxWidth(),
            title = {
                Column {

                    Row {
                        BackButton(modifier = Modifier
                            .padding(top = 20.dp, start = 0.dp)
                            .size(38.dp), onClick = { navController.popBackStack() })
                        SearchInput(
                            modifier = Modifier
                                .padding(start = 10.dp, top = 20.dp)
                                .fillMaxWidth(.95f)
                                .height(38.dp)
                        )
                    }

                    Row(Modifier.padding(start = 15.dp, top = 25.dp)) {
                        TopNavButton(
                            onClick = { selectedButton = 0; listado = ListTypes.Auto },
                            isSelected = selectedButton == 0,
                            text = "Autos"
                        )
                        TopNavButton(
                            onClick = { selectedButton = 1; listado = ListTypes.Pieza },
                            isSelected = selectedButton == 1,
                            text = "Piezas"
                        )
                        TopNavButton(
                            onClick = { selectedButton = 2; listado = ListTypes.Otro },
                            isSelected = selectedButton == 2,
                            text = "Otros"
                        )
                    }

                }
            })

    }
}

enum class ListTypes {
    Auto,
    Pieza,
    Otro
}
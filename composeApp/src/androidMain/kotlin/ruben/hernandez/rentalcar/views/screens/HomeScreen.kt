package ruben.hernandez.rentalcar.views.screens

import MenuDeslizable
import SheetContent
import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

import ruben.hernandez.rentalcar.views.components.BottomNav
import ruben.hernandez.rentalcar.views.components.CarBrand
import ruben.hernandez.rentalcar.views.components.HorizontalCarBrandList
import ruben.hernandez.rentalcar.views.components.ScrolleableLists
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.views.components.CarCard
import ruben.hernandez.rentalcar.views.components.MechanicCarHorizontal
import ruben.hernandez.rentalcar.views.components.SearchInput
import ruben.hernandez.rentalcar.views.components.SectionHeader


@OptIn(ExperimentalMaterialApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun App(navController: NavController) {
    val corrutineScope = rememberCoroutineScope()
    var sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed,
        animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing)
    )
    // Estado que controla el contenido del composable
    var vista by remember { mutableStateOf<@Composable () -> Unit>({}) }

    LaunchedEffect(true) {
        if (sheetState.isCollapsed) {
            vista = {}
        }
    }
    MenuDeslizable(
        sheetContent = vista,
        sheetState = sheetState,
        topPadding = 40.dp,
        parentContent = {

            // Aplica el fondo degradado aquí
            Box(
                modifier = Modifier
//            .fillMaxSize()
                    .background(
                        AppColors.backgroundGreyWhite
                    )
            ) {
                Column {
                    ruben.hernandez.rentalcar.views.components.TopBar()
                    // Todo el contenido de tu app
                    Row(
                        modifier = Modifier.padding(
                            top = 15.dp,
                            start = 20.dp,
                            bottom = 10.dp,
                            end = 20.dp
                        ),
                    ) {
//                MenuPegadoALaBarra()
//
                        SearchInput(
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.width(15.dp))
//                CircularButton(
//                    icon = Icons.Default.Tune,
//                    contentDescription = "",
////                            modifier = Modifier.align(Alignment.End)
//                )
                    }
                    HorizontalCarBrandList(
                        carBrands = listOf(
                            CarBrand(
                                "Mercedes",
                                "https://i.pinimg.com/736x/ec/12/2a/ec122af05ba3534cc01e2cfc269b3c12.jpg"
                            ),
                            CarBrand(
                                "Lada",
                                "https://logopond.com/logos/ef337ee83020b8e9a550f203d2f54fdb.png"
                            ),
                            CarBrand(
                                "Toyota",
                                "https://w0.peakpx.com/wallpaper/463/113/HD-wallpaper-toyota-icio-logo.jpg"
                            ),
                            CarBrand(
                                "Audi",
                                "https://w0.peakpx.com/wallpaper/337/544/HD-wallpaper-audi-logo.jpg"
                            ),
                            CarBrand(
                                "BMW",
                                "https://static.vecteezy.com/system/resources/previews/020/502/870/original/bmw-brand-logo-car-symbol-blue-and-white-design-germany-automobile-illustration-with-black-background-free-vector.jpg"
                            ),

                            )
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(700.dp),
                        shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {

                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(top = 20.dp, bottom = 25.dp)
                        ) {
                            item {
                                SectionHeader(title = "Recientes")
                            }
                            item {
                                MechanicCarHorizontal()
                            }
                            item {
                                Spacer(modifier = Modifier.height(20.dp))
                            }
                            item {
                                SectionHeader(title = "Mejor valorados")
                            }
                            items(5) { index ->
                                CarCard(
                                    carName = "Porsche 718 Cayman S",
                                    carType = "Coupe",
                                    imageUrl = "https://pngimg.com/d/maserati_PNG28.png",
                                    passengers = 2,
                                    transmission = "Manual",
                                    pricePerDay = "$400/d",
                                    onClick = {
                                        corrutineScope.launch {
                                            vista = { SheetContent(sheetState) };sheetState.expand()
                                        }
                                    }
                                )
                                if (index < 4) {  // No añadir espacio después del último item
                                    Spacer(modifier = Modifier.height(16.dp))
                                }
                            }
                        }

                    }

                }



                BottomNav(
                    navController = navController,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                )


            }

        }
    )


}
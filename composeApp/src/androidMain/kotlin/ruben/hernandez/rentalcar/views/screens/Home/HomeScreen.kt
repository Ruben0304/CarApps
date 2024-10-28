package ruben.hernandez.rentalcar.views.screens.Home


import SheetContent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

import ruben.hernandez.rentalcar.views.components.common.BottomNav
import ruben.hernandez.rentalcar.views.components.home.CarBrand
import ruben.hernandez.rentalcar.views.components.home.HorizontalCarBrandList
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials
import kotlinx.coroutines.launch
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.views.components.car.AnimatedCarCard
import ruben.hernandez.rentalcar.views.components.car.CarCard
import ruben.hernandez.rentalcar.views.components.common.MenuDeslizable
import ruben.hernandez.rentalcar.views.components.piezas.MechanicCarHorizontal
import ruben.hernandez.rentalcar.views.components.common.SearchInput
import ruben.hernandez.rentalcar.views.components.common.SectionHeader
import ruben.hernandez.rentalcar.views.components.common.TopBar
import ruben.hernandez.rentalcar.views.screens.Auth.LoginScreen


@RequiresApi(Build.VERSION_CODES.S)
@OptIn(
    ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class,
    ExperimentalHazeMaterialsApi::class
)
@Composable
fun App(navController: NavController) {

    fun isAtLeastApi32() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S_V2
    val coroutineScope = rememberCoroutineScope()
    var sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed,
        animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing)
    )
    var vista by remember { mutableStateOf<@Composable () -> Unit>({}) }
    var isBlured by remember { mutableStateOf(false) }
    var authOpened by remember { mutableStateOf(false) }

    // Estado para controlar qué carta está expandida
    var expandedCardIndex by remember { mutableStateOf<Int?>(null) }

    val blurRadius by animateDpAsState(
        targetValue = if (isBlured) 30.dp else 0.dp,
        animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing)
    )
    val hazeState = remember { HazeState() }
    MenuDeslizable(
        sheetContent = vista,
        sheetState = sheetState,
        topPadding = 60.dp,
        parentContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Brush.linearGradient(AppColors.backgroundGradient))
                    .blur(blurRadius)
            ) {


                var paddinTop = if (isAtLeastApi32()) 0.dp else 165.dp

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = paddinTop)
                        .haze(state = hazeState),
                    contentPadding = PaddingValues(top = 20.dp, bottom = 25.dp),

                    ) {
                    if (isAtLeastApi32())
                        item {
                            Spacer(modifier = Modifier.height(150.dp))
                        }

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
                                coroutineScope.launch {
                                    sheetState.expand();expandedCardIndex = index
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp, vertical = 20.dp)

                        )

                    }

                }
                TopAppBar(
                    colors = TopAppBarDefaults.largeTopAppBarColors(Color.Transparent),

                    modifier = Modifier
                        // We use hazeChild on anything where we want the background
                        // blurred.
                        .hazeChild(
                            state = hazeState,
                        )
                        .height(165.dp)
                        .fillMaxWidth(), title = {
                        Column {


                            TopBar(modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 22.dp),
                                onClick = {
                                    coroutineScope.launch {
                                        isBlured = true
                                    }
                                    authOpened = true
                                })

                        }
                    })
                BottomNav(
                    navController = navController,
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }


            // Login overlay
            AnimatedVisibility(
                visible = authOpened,
                enter = fadeIn(animationSpec = spring()),
                exit = fadeOut(animationSpec = spring())
            ) {
                LoginScreen(
                    onLoginCancel = {
                        coroutineScope.launch {
                            isBlured = false
                            authOpened = false
                        }
                    },
                    onLoginSuccess = {
                        coroutineScope.launch {
                            isBlured = false
                            authOpened = false
                        }
                    }
                )
            }

        }
    )
}
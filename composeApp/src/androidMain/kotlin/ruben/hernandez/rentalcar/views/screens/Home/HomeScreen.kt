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
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
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
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun App(navController: NavController) {
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

    MenuDeslizable(
        sheetContent = vista,
        sheetState = sheetState,
        topPadding = 60.dp,
        parentContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(AppColors.backgroundGreyWhite)
            ) {
                // Contenido principal que se blurrea
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .blur(blurRadius)
                ) {
                    Column {
                        Column {
                            TopBar(onClick = {
                                coroutineScope.launch {
                                    isBlured = true
                                }
                                authOpened = true
                            })
                            Row(
                                modifier = Modifier.padding(
                                    top = 15.dp,
                                    start = 20.dp,
                                    bottom = 10.dp,
                                    end = 20.dp
                                ),
                            ) {
                                SearchInput(
                                    modifier = Modifier.fillMaxWidth()
                                )
                                Spacer(modifier = Modifier.width(15.dp))
                            }
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

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                                )
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
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .zIndex(if (expandedCardIndex == index) 100f else 1f)
                                    ) {
                                        AnimatedCarCard(
                                            carName = "Porsche 718 Cayman S",
                                            carType = "Coupe",
                                            imageUrl = "https://pngimg.com/d/maserati_PNG28.png",
                                            passengers = 2,
                                            transmission = "Manual",
                                            pricePerDay = "$400/d",
                                            isExpanded = expandedCardIndex == index,
                                            onExpand = {
                                                expandedCardIndex = index
                                            },
                                            onCollapse = {
                                                expandedCardIndex = null
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }

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
        }
    )
}
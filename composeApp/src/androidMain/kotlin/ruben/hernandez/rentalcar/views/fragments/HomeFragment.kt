package ruben.hernandez.rentalcar.views.fragments


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import ruben.hernandez.rentalcar.navigation.Destination
import ruben.hernandez.rentalcar.views.components.car.CarCard
import ruben.hernandez.rentalcar.views.components.common.CarrouselPromo
import ruben.hernandez.rentalcar.views.components.common.SectionHeader
import ruben.hernandez.rentalcar.views.components.piezas.MechanicCarHorizontal


@Composable
fun HomeFragment(
    paddingValues: PaddingValues,
    hazeState: HazeState,
    navigateToOtherItem: (String) -> Unit
) {
    LazyColumn(
        contentPadding = paddingValues,
        modifier = Modifier
            .haze(hazeState)
    ) {
        item {
            CarrouselPromo()
        }
        item {
            Spacer(modifier = Modifier.height(20.dp))
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
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 20.dp)

            )

        }
    }
}
//
//@RequiresApi(Build.VERSION_CODES.S)
//@OptIn(
//    ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class,
//    ExperimentalHazeMaterialsApi::class
//)
//@Composable
//fun App(navController: NavController = rememberNavController()) {
//
//
//    val coroutineScope = rememberCoroutineScope()
//    var sheetState = rememberBottomSheetState(
//        initialValue = BottomSheetValue.Collapsed,
//        animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing)
//    )
//    var vista by remember { mutableStateOf<@Composable () -> Unit>({}) }
//    var isBlured by remember { mutableStateOf(false) }
//    var authOpened by remember { mutableStateOf(false) }
//
//    // Estado para controlar qué carta está expandida
//    var expandedCardIndex by remember { mutableStateOf<Int?>(null) }
//
//    val blurRadius by animateDpAsState(
//        targetValue = if (isBlured) 30.dp else 0.dp,
//        animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing)
//    )
//    val hazeState = remember { HazeState() }
//    MenuDeslizable(
//        sheetContent = vista,
//        sheetState = sheetState,
//        topPadding = 60.dp,
//        parentContent = {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Brush.linearGradient(AppColors.backgroundGradient))
//                    .blur(blurRadius)
//            ) {
//
//
//                val paddinTop = if (isAtLeastApi32) 0.dp else 85.dp
//
//                LazyColumn(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(top = paddinTop)
//                        .haze(state = hazeState),
//                    contentPadding = PaddingValues(top = 3.dp, bottom = 25.dp),
//
//                    ) {
//                    if (isAtLeastApi32)
//                        item {
//                            Spacer(modifier = Modifier.height(87.dp))
//                        }
//
//                    item {
//                        CarrouselPromo()
//                    }
//                    item {
//                        Spacer(modifier = Modifier.height(20.dp))
//                    }
//                    item {
//                        SectionHeader(title = "Recientes")
//                    }
//
//                    item {
//                        MechanicCarHorizontal()
//                    }
//
//                    item {
//                        Spacer(modifier = Modifier.height(20.dp))
//                    }
//
//                    item {
//                        SectionHeader(title = "Mejor valorados")
//                    }
//                    items(5) { index ->
//
//                        CarCard(
//                            carName = "Porsche 718 Cayman S",
//                            carType = "Coupe",
//                            imageUrl = "https://pngimg.com/d/maserati_PNG28.png",
//                            passengers = 2,
//                            transmission = "Manual",
//                            pricePerDay = "$400/d",
//                            onClick = {
//                                coroutineScope.launch {
//                                    sheetState.expand();expandedCardIndex = index
//                                }
//                            },
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(horizontal = 15.dp, vertical = 20.dp)
//
//                        )
//
//                    }
//
//                }
//                val mod = Modifier
//                    .height(95.dp)
//                    .fillMaxWidth()
//                TopAppBar(
//                    colors = TopAppBarDefaults.largeTopAppBarColors(Color.Transparent),
//
//
//                    modifier = if (isAtLeastApi32)
//                        mod.hazeChild(
//                            state = hazeState,
//                            style = HazeMaterials.thin(AppColors.navColor)
//                        )
//                    else
//                        mod, title = {
//                        Column {
//
//                            TopBar(modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(top = 15.dp, end = 18.dp, start = 8.dp),
//                                onClick = {
//                                    coroutineScope.launch {
//                                        isBlured = true
//                                    }
//                                    authOpened = true
//                                })
//
//                        }
//                    })
//
//                val modNav = Modifier
//                    .align(Alignment.BottomCenter)
//                    BottomNav(
//                        navController = navController,
//                        modifier = if (isAtLeastApi32)
//                            modNav.hazeChild(
//                                state = hazeState,
//                                style = HazeMaterials.regular(AppColors.navColor)
//                            )
//                        else
//                            modNav
//                    )
//            }
//
//
//            // Login overlay
//            AnimatedVisibility(
//                visible = authOpened,
//                enter = fadeIn(animationSpec = spring()),
//                exit = fadeOut(animationSpec = spring())
//            ) {
//                LoginScreen(
//                    onLoginCancel = {
//                        coroutineScope.launch {
//                            isBlured = false
//                            authOpened = false
//                        }
//                    },
//                    onLoginSuccess = {
//                        coroutineScope.launch {
//                            isBlured = false
//                            authOpened = false
//                        }
//                    }
//                )
//            }
//
//        }
//    )
//}


package ruben.hernandez.rentalcar.views.fragments


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.Part3D
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.mercedeskey
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.views.components.home.ModernHomeCard
import ruben.hernandez.rentalcar.views.components.home.ModernMechanicCard


@Composable
fun StoreFragment(paddingValues: PaddingValues) {

    Column(
        modifier = Modifier
            .background(Color.Transparent)
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(horizontal = 10.dp)) {
            Text(
                text = "Buenas tardes 👋🏼",
                color = AppColors.text,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "¿En qué podemos ayudarte?",
                color = AppColors.text.copy(.85f),
                fontSize = 18.sp
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 20.dp).weight(.35f)
        ) {
            ModernHomeCard(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                onButtonClick = { /*TODO*/ },
                image = painterResource(resource = Res.drawable.Part3D),
                color = AppColors.piezas,
                text = "Encuentra la pieza que necesitas",
                buttonText = "Ver piezas"
            )
            ModernHomeCard(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                onButtonClick = { /*TODO*/ },
                image = painterResource(resource = Res.drawable.mercedeskey),
                color = AppColors.carros,
                text = "Alquila el auto de tus sueños",
                buttonText = "Ver autos"
            )
        }
        ModernMechanicCard(
            modifier = Modifier
                .weight(.25f)
                .padding(horizontal = 10.dp)
                .padding(bottom = 20.dp),
            onButtonClick = { /*TODO*/ },
            image = painterResource(resource = Res.drawable.mercedeskey),
            color = AppColors.principal,
            text = "Explorar mecánicos",
            buttonText = "Explorar"
        )
    }
}
//

//        item {
//            CarrouselPromo()
//        }
//        item {
//            Spacer(modifier = Modifier.height(20.dp))
//        }
//        item {
//            SectionHeader(title = "Recientes")
//        }
//
//        item {
//            MechanicCarHorizontal()
//        }
//
//        item {
//            Spacer(modifier = Modifier.height(20.dp))
//        }
//
//        item {
//            SectionHeader(title = "Mejor valorados")
//        }
//        items(5) { index ->
//
//            CarCard(
//                carName = "Porsche 718 Cayman S",
//                carType = "Coupe",
//                imageUrl = "https://pngimg.com/d/maserati_PNG28.png",
//                passengers = 2,
//                transmission = "Manual",
//                pricePerDay = "$400/d",
//                onClick = {
//
//                },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 10.dp, vertical = 20.dp)
//
//            )
//
//        }


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


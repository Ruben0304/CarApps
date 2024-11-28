package ruben.hernandez.rentalcar.views.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.Account
import carrental.composeapp.generated.resources.Car
import carrental.composeapp.generated.resources.Chat
import carrental.composeapp.generated.resources.Home
import carrental.composeapp.generated.resources.Key
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.Search
import carrental.composeapp.generated.resources.Shopping_Bag
import carrental.composeapp.generated.resources.mecanica
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.views.components.car.CarCard
import ruben.hernandez.rentalcar.views.components.common.BotonColorIconoDerecha
import ruben.hernandez.rentalcar.views.components.common.BottomNav
import ruben.hernandez.rentalcar.views.components.common.ButtonProfile
import ruben.hernandez.rentalcar.views.components.common.ButtonSearch
import ruben.hernandez.rentalcar.views.components.common.CarrouselPromo
import ruben.hernandez.rentalcar.views.components.common.SectionHeader
import ruben.hernandez.rentalcar.views.components.common.TopBar
import ruben.hernandez.rentalcar.views.components.piezas.MechanicCarHorizontal
import ruben.hernandez.rentalcar.views.poppinsFontFamily
import ruben.hernandez.rentalcar.views.util.isAtLeastApi32

data class BottomNavItem(
    val title: String,
    val icon: Painter,
    val route: String
)

@OptIn(ExperimentalMaterial3Api::class, ExperimentalHazeMaterialsApi::class)
@Composable
fun MainLayout(
    content: @Composable (HazeState,PaddingValues) -> Unit
) {
    val navItems =
        listOf(
            BottomNavItem("Inicio", painterResource(resource = Res.drawable.Home), "home"),
            BottomNavItem("Alquilar", painterResource(resource = Res.drawable.Chat), "rent"),
            BottomNavItem("Tienda", painterResource(resource = Res.drawable.Shopping_Bag), "store"),
            BottomNavItem("Mecanicos", painterResource(resource = Res.drawable.Key), "mechanics"),
            BottomNavItem("Ajustes", painterResource(resource = Res.drawable.Account), "settings")
        )

    val hazeState = remember { HazeState() }
    var selectedNavItem by remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = Color.Transparent,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = AppColors.text
                ),
                modifier = Modifier
                    .statusBarsPadding()
                    .hazeChild(
                        state = hazeState,
                        style = HazeMaterials.thin(AppColors.buttonNav)
                    ),
                title = {
                    Column {
                        Text(
                            text = "LA HABANA, CUBA",
                            fontSize = 12.sp,
                            color = AppColors.text.copy(alpha = 0.7f)
                        )
                        Text(
                            text = "Bienvenido",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = AppColors.text
                        )
                    }
                },
                actions = {
                    ButtonSearch(
                        modifier = Modifier.size(42.dp),
                        onClick = { }
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    BotonColorIconoDerecha(
                        icono = painterResource(resource = Res.drawable.Account),
                        color = AppColors.principalLinearGradient,
                        colorSombra = AppColors.principal,
                        texto = "Cuenta",
                        tamanoTexto = 14.sp,
                        alClic = {},
                        forma = CircleShape,
                        altura = 38.dp, // Altura más pequeña
//                        minAltura = 15.dp, // Altura mínima configurable
                        tamanoIcono = 17.dp, // Ajusta el ícono
                        modifier = Modifier.fillMaxWidth(.25f)
                    )

                    Spacer(modifier = Modifier.width(10.dp))
                }
            )
        },
        bottomBar = {
            NavigationBar(
                modifier = if (isAtLeastApi32)
                    Modifier
                        .hazeChild(
                            state = hazeState,
                            style = HazeMaterials.regular(AppColors.cardsBackground.copy(.25f))
                        )
                        .navigationBarsPadding()
                else
                    Modifier.navigationBarsPadding(),
                containerColor = Color.Transparent
            ) {
                navItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                item.icon,
                                contentDescription = item.title,
                                tint = if (selectedNavItem == index) AppColors.navColor else Color.Gray,
                                modifier = Modifier.size(28.dp)
                            )
                        },
                        label = {
                            Text(
                                item.title,
                                color = if (selectedNavItem == index) AppColors.navColor else Color.Gray,
                                fontSize = 12.sp
                            )
                        },
                        selected = false,
                        onClick = { selectedNavItem = index }
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = AppColors.backgroundGradient
                    )
                )
        ) {
            if (isAtLeastApi32)
            Column{
                content(hazeState,paddingValues)
            }
            else
                Box(modifier = Modifier.padding(paddingValues)){content(hazeState,paddingValues)}

        }

    }
}

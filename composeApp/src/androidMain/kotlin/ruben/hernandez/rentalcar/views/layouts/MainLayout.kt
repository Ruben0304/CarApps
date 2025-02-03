package ruben.hernandez.rentalcar.views.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import carrental.composeapp.generated.resources.Account
import carrental.composeapp.generated.resources.Chat
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.Shopping_Bag
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeChild
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.navigation.Destination
import ruben.hernandez.rentalcar.views.components.TopBar
import ruben.hernandez.rentalcar.views.util.isAtLeastApi32

data class BottomNavItem(
    val title: String,
    val icon: Painter,
    val route: String
)

@OptIn(ExperimentalHazeMaterialsApi::class)
@Composable
fun MainLayout(
    content: @Composable (HazeState, PaddingValues, NavHostController) -> Unit,
    onNavigateToSearch: () -> Unit
) {
    val navController = rememberNavController()
    val navItems = listOf(
        BottomNavItem("Tienda", painterResource(resource = Res.drawable.Shopping_Bag), Destination.Store.route),
        BottomNavItem("Consultas", painterResource(resource = Res.drawable.Chat), Destination.Consultation.route),
        BottomNavItem("Ajustes", painterResource(resource = Res.drawable.Account), Destination.Settings.route)
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route


    val hazeState = remember { HazeState() }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = Color.Transparent,
        topBar = {
            TopBar(
                navController = navController,
                currentRoute = currentRoute,
                onSearchClick = onNavigateToSearch // Pasamos la función de navegación
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
                val currentDestination = navController.currentDestination?.route

                navItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                item.icon,
                                contentDescription = item.title,
                                tint = if (currentDestination == item.route)
                                    AppColors.navColor
                                else Color.Gray,
                                modifier = Modifier.size(25.dp)
                            )
                        },
                        label = {
                            Text(
                                item.title,
                                color = if (currentDestination == item.route)
                                    AppColors.navColor
                                else Color.Gray,
                                fontSize = 12.sp
                            )
                        },
                        selected = currentDestination == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                // Pop up to the start destination to avoid building a large stack of destinations
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination on the back stack
                                launchSingleTop = true
                                // Restore state when re-selecting a previously selected item
                                restoreState = true
                            }
                        }
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
            if (isAtLeastApi32) {
                Column {
                    content(hazeState, paddingValues, navController)
                }
            } else {
                Box(modifier = Modifier.padding(paddingValues)) {
                    content(hazeState, paddingValues, navController)
                }
            }
        }
    }
}
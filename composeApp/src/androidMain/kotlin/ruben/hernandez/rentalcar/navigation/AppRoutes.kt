package ruben.hernandez.rentalcar.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.chrisbanes.haze.HazeState
import ruben.hernandez.rentalcar.views.fragments.*

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun AppRoutes(
    navController: NavHostController,
    paddingValues: PaddingValues,
    hazeState: HazeState,
    onNavigate: (String) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Destination.Home.route
    ) {
        composable(Destination.Home.route) {
            HomeFragment(
                paddingValues = paddingValues,
                hazeState = hazeState,
//                navigateToOtherItem = { destination ->
//                    navController.navigate(destination) {
//                        // Avoid multiple copies of the same destination on the back stack
//                        launchSingleTop = true
//                        // Pop up to the start destination to avoid building a large stack of destinations
//                        popUpTo(navController.graph.startDestinationId) {
//                            saveState = true
//                        }
//                        // Restore state when re-selecting a previously selected item
//                        restoreState = true
//                    }
//                    onNavigate(destination)
//                }
            )
        }
        composable(Destination.Rent.route) {
            RentFragment(
                paddingValues = paddingValues,
                hazeState = hazeState,
                navigateToOtherItem = { destination ->
                    navController.navigate(destination) {
                        launchSingleTop = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        restoreState = true
                    }
                    onNavigate(destination)
                }
            )
        }
        composable(Destination.Store.route) {
            StoreFragment(
                paddingValues = paddingValues,
                hazeState = hazeState,
                navigateToOtherItem = { destination ->
                    navController.navigate(destination) {
                        launchSingleTop = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        restoreState = true
                    }
                    onNavigate(destination)
                }
            )
        }
        composable(Destination.Mechanic.route) {
            MechanicFragment(
                paddingValues = paddingValues,
                hazeState = hazeState,
                navigateToOtherItem = { destination ->
                    navController.navigate(destination) {
                        launchSingleTop = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        restoreState = true
                    }
                    onNavigate(destination)
                }
            )
        }
        composable(Destination.Settings.route) {
            SettingsFragment(
                paddingValues = paddingValues,
                hazeState = hazeState,
                navigateToOtherItem = { destination ->
                    navController.navigate(destination) {
                        launchSingleTop = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        restoreState = true
                    }
                    onNavigate(destination)
                }
            )
        }
    }
}

sealed class Destination(val route: String) {
    object Home : Destination("home")
    object Rent : Destination("rent")
    object Store : Destination("store")
    object Mechanic : Destination("mechanic")
    object Settings : Destination("settings")
}
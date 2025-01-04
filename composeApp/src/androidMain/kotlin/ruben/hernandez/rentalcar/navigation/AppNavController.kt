package ruben.hernandez.rentalcar.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.chrisbanes.haze.HazeState
import ruben.hernandez.rentalcar.views.fragments.*
import ruben.hernandez.rentalcar.views.layouts.MainLayout

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = DestinationP.Main.route) {
        composable(DestinationP.Main.route) {
            MainLayout { hazeState, paddingValues, mainNavController ->
                AppRoutes(
                    navController = mainNavController,
                    paddingValues = paddingValues,
                    hazeState = hazeState,
                    onNavigate = { destination ->
                        if (destination == DestinationP.Account.route) {
                            navController.navigate(destination)
                        }
                    }
                )
            }
        }
        composable(DestinationP.Account.route) {
            AccountFragment(
                paddingValues = PaddingValues(),
                hazeState = remember { HazeState() },
                navigateToOtherItem = { navController.popBackStack() }
            )
        }
    }
}

sealed class DestinationP(val route: String) {
    object Account : DestinationP("Cuenta")
    object Main : DestinationP("Principal")
}


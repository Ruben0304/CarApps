package ruben.hernandez.rentalcar.navigation

import ruben.hernandez.rentalcar.views.fragments.SearchFragment
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
            MainLayout(
                content = { hazeState, paddingValues, mainNavController ->
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
                },
                onNavigateToSearch = {
                    navController.navigate(DestinationP.Search.route)
                }
            )
        }
        composable(DestinationP.Account.route) {
            AccountFragment(
                paddingValues = PaddingValues(),
                hazeState = remember { HazeState() },
                navigateToOtherItem = { navController.popBackStack() }
            )
        }
        composable(
            DestinationP.Search.route,
            enterTransition = { slideInVertically { -it } + fadeIn() },
            exitTransition = { slideOutVertically { -it } + fadeOut() }
        ) {
            SearchFragment(
                navigateToOtherItem = { navController.popBackStack() }
            )
        }
    }
}

sealed class DestinationP(val route: String) {
    object Account : DestinationP("Cuenta")
    object Search : DestinationP("Buscar")
    object Main : DestinationP("Principal")
}


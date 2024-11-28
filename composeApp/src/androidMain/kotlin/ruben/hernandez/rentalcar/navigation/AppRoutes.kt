package ruben.hernandez.rentalcar.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.chrisbanes.haze.HazeState
import ruben.hernandez.rentalcar.views.fragments.HomeFragment

import ruben.hernandez.rentalcar.views.screens.SearchScreen


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun AppRoutes(navController: NavHostController,paddingValues: PaddingValues, hazeState : HazeState) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeFragment(paddingValues,hazeState)
        }
        composable(Screen.Search.route) {
            SearchScreen(navController)
        }

//        navController.navigate(Screen.Detail.createRoute("1234"))


//        composable(Screen.Search.route) { backStackEntry ->
//            val itemId = backStackEntry.arguments?.getString("itemId")
//            DetailScreen(navController, itemId)
//        }
    }
}


sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Search : Screen("search")



}
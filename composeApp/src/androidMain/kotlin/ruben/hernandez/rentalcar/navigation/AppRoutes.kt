package ruben.hernandez.rentalcar.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ruben.hernandez.rentalcar.views.screens.App

import ruben.hernandez.rentalcar.views.screens.SearchScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppRoutes(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            App(navController)
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

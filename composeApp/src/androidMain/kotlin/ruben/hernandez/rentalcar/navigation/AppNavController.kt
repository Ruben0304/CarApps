package ruben.hernandez.rentalcar.navigation

import androidx.navigation.NavHostController

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Search : Screen("search")

//    object Detail : Screen("detail/{itemId}") {
//        fun createRoute(itemId: String) = "detail/$itemId"
//    }
}

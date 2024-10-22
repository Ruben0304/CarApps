package ruben.hernandez.rentalcar.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ruben.hernandez.rentalcar.views.screens.Chat.ChatScreen
import ruben.hernandez.rentalcar.views.screens.ChatCenter.ChatsCenterScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChatRoutes(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "chatCenter") {
        composable("chatCenter") {
            ChatsCenterScreen(navController)
        }
        composable("chat") {
            ChatScreen(navController)
        }

//        navController.navigate(Screen.Detail.createRoute("1234"))


//        composable(Screen.Search.route) { backStackEntry ->
//            val itemId = backStackEntry.arguments?.getString("itemId")
//            DetailScreen(navController, itemId)
//        }
    }
}
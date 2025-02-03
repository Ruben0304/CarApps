package ruben.hernandez.rentalcar

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.rememberNavController
import ruben.hernandez.rentalcar.navigation.AppNavigation
import ruben.hernandez.rentalcar.views.theme.CarAppTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            CarAppTheme {
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }
    }
}

//@RequiresApi(Build.VERSION_CODES.S)
//@Preview
//@Composable
//fun AppAndroidPreview() {
//
//    CarAppTheme {
//        MainLayout { hazeState, paddingValues, navController ->
//            AppRoutes(
//                navController = navController,
//                paddingValues = paddingValues,
//                hazeState = hazeState,
//                onNavigate = {} // Optional navigation callback
//            )
//        }
//    }
//}
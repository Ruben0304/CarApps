package ruben.hernandez.rentalcar


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.rememberNavController
import org.koin.android.ext.koin.androidContext
import ruben.hernandez.rentalcar.di.initKoin
import ruben.hernandez.rentalcar.navigation.AppRoutes
import ruben.hernandez.rentalcar.navigation.ChatRoutes
import ruben.hernandez.rentalcar.views.layouts.MainLayout
import ruben.hernandez.rentalcar.views.theme.CarAppTheme


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

                CarAppTheme {
                    MainLayout { hazeState, paddingValues, navController ->
                        AppRoutes(
                            navController = navController,
                            paddingValues = paddingValues,
                            hazeState = hazeState,
                            onNavigate = {} // Optional navigation callback
                        )
                    }
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
package ruben.hernandez.rentalcar


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import ruben.hernandez.rentalcar.navigation.AppRoutes


import ruben.hernandez.rentalcar.navigation.ChatRoutes

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            AppRoutes(navController = navController)
            ChatRoutes(navController = navController)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable
fun AppAndroidPreview() {
    val navController = rememberNavController()
    AppRoutes(navController = navController)
    //ChatRoutes(navController = navController)
}
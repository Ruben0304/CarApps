package ruben.hernandez.rentalcar


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import ruben.hernandez.rentalcar.navigation.AppRoutes


import ruben.hernandez.rentalcar.navigation.ChatRoutes
import ruben.hernandez.rentalcar.views.components.car.CarCard
import ruben.hernandez.rentalcar.views.components.common.CarrouselPromo
import ruben.hernandez.rentalcar.views.components.common.SectionHeader
import ruben.hernandez.rentalcar.views.components.piezas.MechanicCarHorizontal
import ruben.hernandez.rentalcar.views.fragments.HomeFragment
import ruben.hernandez.rentalcar.views.layouts.MainLayout
import ruben.hernandez.rentalcar.views.theme.CarAppTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CarAppTheme {
                val navController = rememberNavController()
//                AppRoutes(navController = navController)
                ChatRoutes(navController = navController)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable
fun AppAndroidPreview() {
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
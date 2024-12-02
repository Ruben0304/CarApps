package ruben.hernandez.rentalcar.views.fragments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.navigation.Destination

@Composable
fun RentFragment(
    paddingValues: PaddingValues,
    hazeState: HazeState,
    navigateToOtherItem: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .haze(hazeState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sección de Renta",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = AppColors.principal
        )
        Text(
            text = "Fragmento en implementación",
            fontSize = 18.sp,
            color = AppColors.principal
        )
    }
}
package ruben.hernandez.rentalcar.components.atoms

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ruben.hernandez.rentalcar.AppColors

@Composable
fun LoginTitle() {
    Text(
        text = "Iniciar sesión",
        color = AppColors.navColor,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
}
package ruben.hernandez.rentalcar.components.atoms

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun ForgotPassword(modifier: Modifier = Modifier) {
    Text(
        text = "¿Olvidaste tu contraseña 🤔?",
        color = Color(14, 13, 13, 255),
        fontSize = 13.sp,
        modifier = modifier
            .clickable {
                // TODO: Implementar funcionalidad de recuperación de contraseña
                // Aquí iría la lógica para manejar el olvido de contraseña
            }
    )
}
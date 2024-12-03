package ruben.hernandez.rentalcar

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import ruben.hernandez.rentalcar.AppColors.darkMode

object AppColors {
    var darkMode by mutableStateOf(false)

    val buttonNav: Color
        get() = if(darkMode) Color.Black.copy(0.25f) else Color.White.copy(0.25f)

    val navColor: Color
        get() = Color.Gray

    val navColorSelected: Color
        get() = if(darkMode) Color.White else Color.Black

    val text: Color
        get() = if (darkMode) Color.White else Color(41, 41, 46)

    val cardsBackground: Color
        get() = if (darkMode) Color(0xFF1C1C1D) else Color.White

    val principal: Color
        get() = if (darkMode) Color(137,113,57) else Color(137,113,57)

    val piezas: Color
        get() = if (darkMode) Color(57,137,78) else Color(76,168,100)

    val carros: Color
        get() = if (darkMode) Color(57,88,137) else Color(57,88,137)

    val principalLinearGradient: List<Color>
        get() = listOf(Color(173,143,104), Color(163,133,94))

    val backgroundGradient: List<Color>
        get() = if (darkMode)
            listOf(Color(0,0,0), Color(0,0,0))
        else listOf(Color(255, 255, 255, 255), Color(255, 255, 255, 255), principal.copy(.15f))
}
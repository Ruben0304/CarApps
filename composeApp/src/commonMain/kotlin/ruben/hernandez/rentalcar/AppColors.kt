package ruben.hernandez.rentalcar

import androidx.compose.ui.graphics.Color

object AppColors{
    val darkMode = true

    val buttonNav = if(darkMode) Color.White else Color(41, 41, 46)
    val navColor = if(darkMode) Color(25, 26, 30) else Color.White
    val text = if (darkMode) Color.White else Color(41, 41, 46)
    val cardsBackground= if (darkMode) Color(31,41,55) else Color.White
    val principal = Color(88, 133, 243, 255)
    val backgroundGradient = if (darkMode)  listOf(Color(25, 26, 30),Color(25, 26, 30)) else listOf(Color(250, 247, 247, 255), principal.copy(.25f))
}
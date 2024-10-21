package ruben.hernandez.rentalcar.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ruben.hernandez.rentalcar.views.poppinsFontFamily

@Composable
fun BotonPerfilChatCenter(
    modifier: Modifier = Modifier,
    nombre: String,
    apellido: String,
    onClick: () -> Unit = {}
){
    Surface(
        modifier = modifier.size(37.dp),
        shape = CircleShape,
        onClick = onClick
    ) {
        Text(
            text = nombre[0].toString(),
            fontSize = 18.sp,
            fontFamily = poppinsFontFamily,
            color = Color.White,
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(103, 142, 248, 255), Color(84, 157, 244, 255)
                        )
                    ), shape = CircleShape
                )
                .padding(start = 13.dp, top = 7.dp)
        )
    }
}
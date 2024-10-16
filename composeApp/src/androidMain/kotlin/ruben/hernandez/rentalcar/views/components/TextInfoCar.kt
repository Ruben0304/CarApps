package ruben.hernandez.rentalcar.views.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.CarDoorBlue
import carrental.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Resource
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.views.poppinsFontFamily
import java.time.format.TextStyle


@Composable
fun TextInfoCar(
    texto: String,
    recurso: Painter,
    modifierRow: Modifier = Modifier,
    modifierIcon: Modifier = Modifier,
    textStyle: TextUnit
) {
    Row (
        modifier = modifierRow
    ) {
        Icon(
            painter = recurso,
            contentDescription = null,
            tint = Color(0, 126, 255),
            modifier = modifierIcon
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = texto,
            fontSize = textStyle,
            fontFamily = poppinsFontFamily,
            color = Color.Black
        )
    }
}

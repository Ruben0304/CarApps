package ruben.hernandez.rentalcar.views.components.car

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
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
import ruben.hernandez.rentalcar.views.poppinsFontFamily


@Composable
fun TextInfoCar(
    texto: String,
    recurso: Painter,
    modifierRow: Modifier = Modifier,
    modifierIcon: Modifier = Modifier,
    textStyle: TextUnit
) {
    Row (
        modifier = modifierRow.padding(bottom = 14.dp)
    ) {
        Icon(
            painter = recurso,
            contentDescription = null,
            tint = Color(15, 112, 231, 255),
            modifier = modifierIcon
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = texto,
            fontSize = 14.sp,
            fontFamily = poppinsFontFamily,
            color = Color.Black
        )
    }
}

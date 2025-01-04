package ruben.hernandez.rentalcar.views.components.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Rating(
    modifier: Modifier = Modifier,
    rating: Float,
    fontSize: TextUnit = 15.sp,
    iconSize: Dp = 22.dp
) {
    Surface(
        color = Color(0xFFF2E6D3),
        shape = CircleShape,
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .defaultMinSize(minWidth = iconSize * 2.5f) // Asegura un ancho mínimo proporcional
                .padding(
                    vertical = (iconSize * 0.36f).coerceAtLeast(8.dp),
                    horizontal = (iconSize * 0.82f).coerceAtLeast(18.dp)
                )
        ) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Rating",
                tint = Color(0xFFFFC107),
                modifier = Modifier
                    .size(iconSize)
                    .wrapContentSize(align = Alignment.Center)
            )
            Spacer(
                modifier = Modifier
                    .width((iconSize * 0.27f).coerceAtLeast(6.dp))
            )
            Text(
                text = rating.toString(),
                fontSize = fontSize,
                fontWeight = FontWeight.W500,
                color = Color(43, 38, 38),
                modifier = Modifier.wrapContentSize(align = Alignment.Center)
            )
        }
    }
}
package ruben.hernandez.rentalcar.components.atoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.profile

@Composable
fun LoginLogo() {
    Image(
        painter = org.jetbrains.compose.resources.painterResource(resource = Res.drawable.profile),
        contentDescription = null,
        modifier = Modifier
            .size(120.dp)
            .graphicsLayer {
                shadowElevation = 8.dp.toPx()
                shape = CircleShape
            }
            .border(
                BorderStroke(
                    3.dp, brush = Brush.horizontalGradient(
                        listOf(
                            Color(128, 120, 247, 255),
                            Color(88, 133, 243, 255)
                        )
                    )
                ), shape = CircleShape
            )
    )
}
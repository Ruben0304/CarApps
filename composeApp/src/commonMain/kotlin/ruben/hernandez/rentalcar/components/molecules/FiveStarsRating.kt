package ruben.hernandez.rentalcar.views.components.common

import androidx.compose.runtime.Composable


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun FiveStarRating(
    rating: Float,
    modifier: Modifier = Modifier,
    starSize: Dp = 20.dp,
    starSpacing: Dp = 4.dp,
    activeColor: Color = Color(0xFFFFC107),
    inactiveColor: Color = Color.LightGray
) {
    // Validar que el rating esté entre 0 y 5
    val validRating = rating.coerceIn(0f, 5f)

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(starSpacing)
    ) {
        repeat(5) { index ->
            val starProgress = (validRating - index).coerceIn(0f, 1f)

            Box(
                modifier = Modifier
                    .size(starSize),
                contentAlignment = Alignment.Center
            ) {
                // Estrella inactiva (fondo)
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    tint = inactiveColor,
                    modifier = Modifier.fillMaxSize()
                )

                // Estrella activa (se muestra parcialmente según el rating)
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Rating star ${index + 1}",
                    tint = activeColor,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(ClipRatingMask(starProgress))
                )
            }
        }
    }
}

// Clase personalizada para recortar la estrella según el progreso
private class ClipRatingMask(private val progress: Float) : Shape {
    override fun createOutline(
        size: androidx.compose.ui.geometry.Size,
        layoutDirection: androidx.compose.ui.unit.LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Rectangle(
            Rect(
                left = 0f,
                top = 0f,
                right = size.width * progress,
                bottom = size.height
            )
        )
    }
}



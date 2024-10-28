package ruben.hernandez.rentalcar.views.components.common

import android.util.LayoutDirection
import android.util.Size
import androidx.compose.runtime.Composable


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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

import androidx.compose.runtime.MonotonicFrameClock
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ruben.hernandez.rentalcar.views.poppinsFontFamily


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

// Preview del componente
@Preview(showBackground = true)
@Composable
fun FiveStarRatingPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        // Rating de 4.5
        FiveStarRating(
            rating = 4.5f,
            starSize = 24.dp
        )

        // Rating de 3.7
        FiveStarRating(
            rating = 3.7f,
            starSize = 24.dp,
            activeColor = Color(0xFFFF9800)
        )

        // Rating de 2.0
        FiveStarRating(
            rating = 2.0f,
            starSize = 24.dp
        )
    }
}


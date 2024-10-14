package ruben.hernandez.rentalcar.glassmorphism

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayVector
import ruben.hernandez.rentalcar.R

/**
 * This composable was generated from the UI Package 'glassmorphism'.
 * Generated code; do not edit directly
 */
@Composable
fun Glassmorphism(
    modifier: Modifier = Modifier,
    color: Color = Color(
        alpha = 0,
        red = 0,
        green = 0,
        blue = 0
    )
) {
    TopLevel(
        color = color,
        modifier = modifier
    ) {
        Rectangle2(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
    }
}

@Preview(widthDp = 364, heightDp = 121)
@Composable
private fun GlassmorphismPreview() {
    MaterialTheme {
        RelayContainer {
            Glassmorphism(
                color = Color(
                    alpha = 0,
                    red = 0,
                    green = 0,
                    blue = 0
                ),
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun Rectangle2(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.glassmorphism_rectangle_2),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun TopLevel(
    color: Color,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = color,
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

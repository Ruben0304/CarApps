package ruben.hernandez.rentalcar.views.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable

fun BackButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Surface(
        onClick = onClick,
        color = Color.White,
        shape = CircleShape,
        shadowElevation = 8.dp,
        modifier = modifier

    ) {
        Icon(imageVector = Icons.Filled.ArrowBackIosNew, contentDescription = "back", tint = Color.Gray, modifier = Modifier.padding(12.dp))
    }
}
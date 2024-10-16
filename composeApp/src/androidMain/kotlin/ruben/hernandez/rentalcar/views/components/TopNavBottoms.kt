package ruben.hernandez.rentalcar.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopNavButton(onClick: () -> Unit, isSelected: Boolean, text: String) {
    if (isSelected)
        Surface(
            shape = CircleShape,
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color(161, 161, 248, 255), Color(102, 157, 250, 255)
                        )
                    ), shape = CircleShape
                )
//                .shadow(spotColor = Color(113, 163, 248, 255), elevation = 18.dp, shape = CircleShape)
                .height(33.dp),
            shadowElevation = 35.dp,
            tonalElevation = 35.dp,
            color = Color.Transparent,
        ) {
            Text(
                text = text,
                fontSize = 19.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 25.dp)
            )
        }
    else
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color(68, 67, 67, 255),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 25.dp)
                .clickable(onClick = onClick)
        )
}
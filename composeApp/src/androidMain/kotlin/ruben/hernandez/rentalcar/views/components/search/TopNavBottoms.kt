package ruben.hernandez.rentalcar.views.components.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.views.components.common.BotonColor
import ruben.hernandez.rentalcar.views.poppinsFontFamily

@Composable
fun TopNavButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    isSelected: Boolean,
    text: String
) {
    val interactionSource = remember { MutableInteractionSource() }
    val haptic = LocalHapticFeedback.current
    Box(modifier = modifier.width(75.dp)
        .height(33.dp)) {
    if (isSelected) {
        Card(
            colors = CardDefaults.cardColors(containerColor = AppColors.principal),
            modifier = Modifier
                .fillMaxSize(.9f)
                .align(Alignment.Center)
                .shadow(
                    elevation = 12.dp,
                    spotColor = Color.Blue,
                    ambientColor = Color.Blue,
                    shape = CircleShape
                ),
            shape = CircleShape,
        ) {}
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color(245, 243, 243, 255),
            fontFamily = poppinsFontFamily,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )
    }
    else
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color.DarkGray,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .clickable(
                    onClick = { onClick();haptic.performHapticFeedback(HapticFeedbackType.LongPress) },
                    interactionSource = interactionSource,
                    indication = null
                )
                .align(Alignment.Center)
        )
    }
}
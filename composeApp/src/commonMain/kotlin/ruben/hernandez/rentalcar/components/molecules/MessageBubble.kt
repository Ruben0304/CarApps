package ruben.hernandez.rentalcar.components.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.models.ChatMessage

@Composable
fun MessageBubble(message: ChatMessage) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (message.isReceived) Alignment.Start else Alignment.End
    ) {
        Surface(elevation = 3.dp, shape =  RoundedCornerShape(
            topStart = 18.dp,
            topEnd = 18.dp,
            bottomStart = if (message.isReceived) 0.dp else 18.dp,
            bottomEnd = if (message.isReceived) 18.dp else 0.dp
        ),color = Color.Transparent) {
            Box(
                modifier = Modifier
                    .widthIn(max = 280.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 18.dp,
                            topEnd = 18.dp,
                            bottomStart = if (message.isReceived) 0.dp else 18.dp,
                            bottomEnd = if (message.isReceived) 18.dp else 0.dp
                        )
                    )
                    .background(if (message.isReceived) Color(0xFFE5E5EA) else Color(0xFF007AFF))
                    .padding(12.dp)

            ) {
                if (message.imageUri != null) {
//                    Image(
//                        painter = rememberAsyncImagePainter(message.imageUri),
//                        contentDescription = null,
//                        modifier = Modifier.size(150.dp)
//                    )
                } else {
                    Text(
                        text = message.content ?: "",
                        color = if (message.isReceived) Color.Black else AppColors.cardsBackground,
                        style = TextStyle(fontSize = 16.sp),
                        modifier = Modifier.align(if (message.isReceived) Alignment.CenterStart else Alignment.CenterEnd)
                    )
                }
            }
        }

    }
}
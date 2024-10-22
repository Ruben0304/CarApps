package ruben.hernandez.rentalcar.views.components.chat

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseOutQuad
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ruben.hernandez.rentalcar.models.ChatItem

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun ChatsList(
    modifier: Modifier = Modifier,
    listaConversaciones: List<ChatItem>,
    onClick: (String) -> Unit
) {
    AnimatedVisibility(
        visible = true,
        enter = fadeIn(animationSpec = tween(durationMillis = 100))
    ) {
        LazyColumn(
            modifier = modifier
                .background(Color.White),
        ) {
            itemsIndexed(listaConversaciones) { index, item ->
                val animatedProgress = remember {
                    androidx.compose.animation.core.Animatable(
                        initialValue = 0f
                    )
                }

                LaunchedEffect(key1 = Unit) {
                    animatedProgress.animateTo(
                        targetValue = 1f,
                        animationSpec = tween(
                            durationMillis = 250,
                            easing = EaseOutQuad,
                            delayMillis = index * 60
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .alpha(animatedProgress.value)
                        .offset(y = (20 * (1f - animatedProgress.value)).dp)
                ) {
                    ChatItemComponent(
                        contenido = item,
                        onClick = onClick

                    )
                }
            }
        }
    }
}

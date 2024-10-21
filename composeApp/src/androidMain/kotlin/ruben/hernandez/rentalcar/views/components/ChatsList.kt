package ruben.hernandez.rentalcar.views.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseOutQuad
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ChatsList(
    modifier: Modifier = Modifier,
    listaConversaciones: List<ChatItem>,
    modifierCaja: Modifier = Modifier,
    modifierNombre: Modifier = Modifier,
    modifierContent: Modifier = Modifier,
    modifierHora: Modifier = Modifier,
    modifierNotificaciones: Modifier = Modifier
) {
    AnimatedVisibility(
        visible = true,
        enter = fadeIn(animationSpec = tween(durationMillis = 100))
    ) {
        LazyColumn(
            modifier = modifier
                .background(Color.White)
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
                    ChatItemScreen(
                        contenido = item,
                        modifier = modifierCaja,
                        modifierNombre = modifierNombre,
                        modifierContent = modifierContent,
                        modifierHora = modifierHora,
                        modifierNotificaciones = modifierNotificaciones
                    )
                }
            }
        }
    }
}

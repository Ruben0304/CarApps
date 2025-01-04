package ruben.hernandez.rentalcar.components.organism

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInVertically
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ruben.hernandez.rentalcar.components.molecules.MessageBubble
import ruben.hernandez.rentalcar.models.ChatMessage

@Composable
fun AnimatedMessageBubble(message: ChatMessage) {
    val animationDuration = 200 // Duración de la animación en milisegundos

    // Usamos LaunchedEffect para animar solo cuando el mensaje se agrega
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(message) {
        visible = true
    }

    // Animamos la visibilidad del mensaje cuando se agrega
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(animationSpec = tween(animationDuration)) +
                slideInVertically(
                    initialOffsetY = { it }, // Desplaza desde la parte inferior
                    animationSpec = tween(animationDuration)
                ) + scaleIn(
            initialScale = 0.8f,
            animationSpec = tween(animationDuration)
        ),
        exit = fadeOut(animationSpec = tween(animationDuration))
    ) {
        MessageBubble(message)
    }
}
package ruben.hernandez.rentalcar.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    LazyColumn(
        modifier = modifier
            .background(Color.White)
    ) {
        items(listaConversaciones) { item ->
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

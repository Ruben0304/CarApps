package ruben.hernandez.rentalcar.views.screens.Chat

import android.net.Uri

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.IconButton
//noinspection UsingMaterialAndMaterial3Libraries

import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import carrental.composeapp.generated.resources.Phone
import carrental.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
//import ruben.hernandez.rentalcar.appclip.Icon
//import ruben.hernandez.rentalcar.messagesthreadname.MessagesThreadName

import ruben.hernandez.rentalcar.views.components.AnimatedMessageBubble
import ruben.hernandez.rentalcar.views.components.BackButton
import ruben.hernandez.rentalcar.views.components.CohereAI
import ruben.hernandez.rentalcar.views.components.ElegantChatInput

data class ChatMessage(
    val id: Int,
    val content: String? = null,  // Mensaje de texto
    val imageUri: Uri? = null,     // Imagen (si aplica)
    val isReceived: Boolean
)

@Composable
fun ChatScreen(navController: NavController = rememberNavController()) {
    var messages by remember { mutableStateOf(listOf<ChatMessage>()) }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BackButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .size(40.dp)
            )
//            MessagesThreadName(
//                nombre = painterResource(Res.drawable.descarga),
//                modifier = Modifier.padding(top = 20.dp)
//            )
            IconButton(
                onClick = { /* TODO */ }, modifier = Modifier
                    .size(40.dp)
            ) {
                androidx.compose.material.Icon(
                    painter = painterResource(Res.drawable.Phone),
                    contentDescription = "",
                    modifier = Modifier.size(30.dp)
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 90.dp),
            state = listState,
            contentPadding = PaddingValues(horizontal = 25.dp, vertical = 8.dp),
            reverseLayout = true
        ) {
            items(messages.reversed(), key = { it.id }) { message ->
                AnimatedMessageBubble(message)
                Spacer(modifier = Modifier.height(4.dp))
            }
        }

        ElegantChatInput(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            onSendMessage = { newMessage ->
                val isReceived = false
                // Agregar el mensaje enviado a la lista
                messages = messages + ChatMessage(
                    id = messages.size,
                    content = newMessage,
                    isReceived = isReceived
                )

                // Llamar a la función asíncrona para obtener la respuesta de la IA
                coroutineScope.launch {
                    // Llamar a la función asíncrona
                    messages = messages + ChatMessage( // Agregar respuesta a la lista
                        id = messages.size,
                        content = CohereAI.generateLlmPrompt(newMessage),
                        isReceived = true // Marcar como recibido
                    )
                    listState.animateScrollToItem(0) // Desplazar hacia el mensaje más reciente
                }
            },
            onSendImage = { imageUri ->
                val isReceived = false
                messages = messages + ChatMessage(
                    id = messages.size,
                    imageUri = imageUri,
                    isReceived = isReceived
                )
                coroutineScope.launch {
                    listState.animateScrollToItem(0)
                }
            }
        )
    }
}

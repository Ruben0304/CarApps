package ruben.hernandez.rentalcar.models

data class ChatMessage(
    val id: Int,
    val content: String? = null,  // Mensaje de texto
    val imageUri: String? = null,     // Imagen (si aplica)
    val isReceived: Boolean
)


data class ChatItem(
    val nombre: String,
    val ultimoMensg: String,
    val cantNotif: Int,
    val fecha: String,
    val id: String = "123"
)
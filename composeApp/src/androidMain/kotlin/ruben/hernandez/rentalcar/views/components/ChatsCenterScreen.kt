package ruben.hernandez.rentalcar.views.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import carrental.composeapp.generated.resources.MessagingWhite
import carrental.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.views.poppinsFontFamily

data class User(
    val nombre: String,
    val apellido: String,
    val conversaciones: List<ChatItem>
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChatsCenterScreen(
    user: User,
    navController: NavController = rememberNavController(),
    onClickConfiguracion: () -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White).padding( top = 10.dp, start = 10.dp, end = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BackButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .size(35.dp)
                )
                BotonPerfilChatCenter(
                    nombre = user.nombre,
                    apellido = user.apellido
                )
            }
            Row(
                modifier = Modifier.padding(top = 15.dp, bottom = 10.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Chats",
                    fontSize = 28.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = AppColors.dark
                )
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = Color.White,
                    modifier = Modifier.size(30.dp).padding(end = 4.dp),
                    onClick = onClickConfiguracion

                ) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "back",
                        tint = AppColors.dark,
                    )
                }
            }

            SearchInput(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            ChatsList(
                listaConversaciones = user.conversaciones,
                modifier = Modifier.fillMaxWidth(),
                modifierNotificaciones = Modifier.padding(start = 8.dp)
            )

        }
        Box(
            modifier = Modifier.fillMaxSize().padding(bottom = 20.dp, end = 10.dp),
            contentAlignment = Alignment.BottomEnd
        ){
            BotonColor(
                texto = "Nuevo Chat",
                icono = painterResource(resource = Res.drawable.MessagingWhite),
                tamanoIcono = 20.dp
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun PreviewChatsCenter() {
    val conversaciones = listOf(
        ChatItem(
            nombre = "Alberto mecanico", ultimoMensg =
            "El problema podria ser de corriente, la bobina que parece estar sucia",
            cantNotif = 7, fecha = "22:43 pm"
        ),
        ChatItem(
            nombre = "Juan mecanico", ultimoMensg =
            "No tengo solucion momentaneamente",
            cantNotif = 5, fecha = "10:35 am"
        ),
        ChatItem(
            nombre = "Pepe mec", ultimoMensg =
            "Revisa el carburador",
            cantNotif = 1, fecha = "8:00 am"
        ),
        ChatItem(
            nombre = "Alberto mecanico", ultimoMensg =
            "El problema podria ser de corriente, la bobina que parece estar sucia",
            cantNotif = 10, fecha = "22:43 pm"
        ),
        ChatItem(
            nombre = "Alberto mecanico", ultimoMensg =
            "El problema podria ser de corriente, la bobina que parece estar sucia",
            cantNotif = 2, fecha = "22:43 pm"
        ),
        ChatItem(
            nombre = "Alberto mecanico", ultimoMensg =
            "El problema podria ser de corriente, la bobina que parece estar sucia",
            cantNotif = 7, fecha = "22:43 pm"
        ),
        ChatItem(
            nombre = "Alberto mecanico", ultimoMensg =
            "El problema podria ser de corriente, la bobina que parece estar sucia",
            cantNotif = 7, fecha = "22:43 pm"
        ),
        ChatItem(
            nombre = "Alberto mecanico", ultimoMensg =
            "El problema podria ser de corriente, la bobina que parece estar sucia",
            cantNotif = 7, fecha = "22:43 pm"
        ),
        ChatItem(
            nombre = "Alberto mecanico", ultimoMensg =
            "El problema podria ser de corriente, la bobina que parece estar sucia",
            cantNotif = 7, fecha = "22:43 pm"
        ),
        ChatItem(
            nombre = "Alberto mecanico", ultimoMensg =
            "El problema podria ser de corriente, la bobina que parece estar sucia",
            cantNotif = 7, fecha = "22:43 pm"
        )
    )

    val usuario = User(
        nombre = "Eduardo",
        apellido = "Fonseca",
        conversaciones = conversaciones
    )

    ChatsCenterScreen(user = usuario, onClickConfiguracion = { })

}
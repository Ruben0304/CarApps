package ruben.hernandez.rentalcar.views.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
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
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
            .padding(start = 10.dp, top = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            BackButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
//                    .padding(top = 10.dp)
                    .size(35.dp)
            )
            BotonPerfilChatCenter(
                nombre = user.nombre,
                apellido = user.apellido,
                modifier = Modifier.padding(start = 280.dp)
            )
        }
        Row(
            modifier = Modifier.padding(top = 15.dp, bottom = 10.dp)
        ) {
            Text(
                text = "Chats",
                fontSize = 28.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
                color = AppColors.dark
            )
            Spacer(modifier = Modifier.width(246.dp))
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = Color.White,
                modifier = Modifier.size(30.dp),
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
                .padding(end = 15.dp)
                .fillMaxWidth()
                .height(40.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        ChatsList(listaConversaciones = user.conversaciones, modifier = Modifier.fillMaxWidth(), modifierNotificaciones = Modifier.padding(start = 8.dp))
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
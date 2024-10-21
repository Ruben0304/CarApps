package ruben.hernandez.rentalcar.views.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import carrental.composeapp.generated.resources.MessagingWhite
import carrental.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors

data class User(
    val nombre: String,
    val apellido: String,
    val conversaciones: List<ChatItem>
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChatsCenterScreen(
    navController: NavController = rememberNavController(),
    conversaciones: List<ChatItem>,
    onClickConfiguracion: () -> Unit,
) {
    Scaffold(containerColor = Color.White, floatingActionButton = {
        BotonColor(
            texto = "Consultar",
            icono = painterResource(resource = Res.drawable.MessagingWhite),
            tamanoIcono = 26.dp,
            tamanoTexto = 18.sp,
            modifier = Modifier
                .height(60.dp)
                .padding(bottom = 10.dp),
            colorSombra = AppColors.principal
        )
    }, topBar = {

            Row(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp, top = 15.dp)

            ) {
                BackButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .size(40.dp)
                )
                SearchInput(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 10.dp)
                        .height(40.dp)
                )

                Surface(
                    modifier = Modifier
                        .size(40.dp),
                    shadowElevation = 8.dp,
                    shape = CircleShape,
                    onClick = onClickConfiguracion,
                    color = AppColors.dark
                ) {
                    Box {
                        Text(
                            text = "RH",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }


    }
    ) { paddingValues ->

        ChatsList(
            listaConversaciones = conversaciones,
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(end = 8.dp, start = 12.dp, top = 20.dp),

        )


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
    )

    val usuario = User(
        nombre = "Eduardo",
        apellido = "Fonseca",
        conversaciones = conversaciones
    )

    ChatsCenterScreen(conversaciones = conversaciones, onClickConfiguracion = { })

}
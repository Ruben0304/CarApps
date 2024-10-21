package ruben.hernandez.rentalcar.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.views.poppinsFontFamily

data class ChatItem(
    val nombre: String,
    val ultimoMensg: String,
    val cantNotif: Int,
    val fecha: String,
)

@Preview
@Composable
fun preview() {

    val instancia = ChatItem(
        nombre = "Alberto mecanico", ultimoMensg =
        "El problema podria ser de corriente, la bobina que parece estar sucia",
        cantNotif = 7, fecha = "22:43pm"
    )

    ChatItemScreen(
        Modifier
            .fillMaxWidth()
            .height(65.dp),
        contenido = instancia
    )
}

@Composable
fun ChatItemScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    contenido: ChatItem,
    modifierNombre: Modifier = Modifier,
    modifierContent: Modifier = Modifier,
    modifierHora: Modifier = Modifier,
    modifierNotificaciones: Modifier = Modifier
) {
    Surface(
        shape = RectangleShape,
        modifier = modifier,
        onClick = onClick

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(top = 4.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                ) {
                    Text(
                        text = contenido.nombre,
                        fontSize = 18.sp,
                        fontFamily = poppinsFontFamily,
                        color = AppColors.dark,
                        modifier = modifierNombre
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = contenido.ultimoMensg,
                        fontSize = 14.sp,
                        fontFamily = poppinsFontFamily,
                        color = Color.Gray,
                        modifier = modifierContent
                            .height(45.dp)
                            .width(280.dp)
                    )

                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = contenido.fecha,
                        fontSize = 15.sp,
                        fontFamily = poppinsFontFamily,
                        color = Color.Gray,
                        modifier = modifierHora
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    // Circulo pequenio de notificaciones
                    Surface(
                        modifier = modifierNotificaciones
                            .padding(top = 4.dp, end = 17.dp)
                            .width(20.dp)
                            .height(20.dp),
                        shape = CircleShape,
                        onClick = onClick
                    ) {
                        Text(
                            text = contenido.cantNotif.toString(),
                            fontSize = 13.sp,
                            fontFamily = poppinsFontFamily,
                            color = Color.White,
                            modifier = Modifier
                                .background(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            Color(103, 142, 248, 255), Color(84, 157, 244, 255)
                                        )
                                    ), shape = CircleShape
                                )
                                .padding(start = 6.dp, top = 1.dp)
                        )
                    }

                }

            }
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(214, 219, 234, 255), Color(187, 194, 201, 255)
                            )
                        )
                    )
                    .fillMaxWidth()
            )
        }
    }
}



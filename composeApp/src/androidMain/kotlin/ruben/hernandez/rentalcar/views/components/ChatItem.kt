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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.views.poppinsFontFamily

data class ChatItem(
    val nombre: String,
    val ultimoMensg: String,
    val cantNotif: Int,
    val fecha: String,
    val id: String = "123"
)


@Composable
fun ChatItem(
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit,
    contenido: ChatItem,
) {
    Surface(
        shape = RectangleShape,
        modifier = modifier,
        onClick = {
            onClick(contenido.id)
        },
        color = Color.White

    ) {
        Box {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Column {
                    Text(
                        text = contenido.nombre,
                        fontSize = 18.sp,
                        fontFamily = poppinsFontFamily,
                        color = AppColors.dark,
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = contenido.ultimoMensg,
                        fontSize = 14.sp,
                        fontFamily = poppinsFontFamily,
                        color = Color.Gray,
                        modifier = Modifier
                            .height(45.dp)
                            .width(280.dp)
                    )

                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End,
                ) {
                    Text(
                        text = contenido.fecha,
                        fontSize = 15.sp,
                        fontFamily = poppinsFontFamily,
                        color = Color.Gray
                    )


                    // Circulo pequenio de notificaciones
                    Box(
                        modifier = Modifier
                            .padding(top = 8.dp, end = 17.dp)
                            .width(20.dp)
                            .height(20.dp)
                            .background(color = AppColors.principal, shape = CircleShape),
                    ) {
                        Text(
                            text = contenido.cantNotif.toString(),
                            fontSize = 12.sp,
                            fontFamily = poppinsFontFamily,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .align(Alignment.Center)
                        )
                    }

                }
            }
            HorizontalDivider(modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}



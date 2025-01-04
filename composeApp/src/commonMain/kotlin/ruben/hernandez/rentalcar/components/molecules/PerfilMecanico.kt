package ruben.hernandez.rentalcar.components.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.models.Mecanico

@Composable
fun PerfilMecanico(
    mecanico: Mecanico, modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(end = 10.dp, bottom = 10.dp).width(100.dp).background(AppColors.cardsBackground),
        onClick = onClick
    ) {
        Column(
            Modifier
                .background(AppColors.cardsBackground)
                .padding(start = 2.dp, end = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Image(
//                painter = rememberAsyncImagePainter(model = mecanico.fotoPerfil),
//                contentDescription = "foto perfil",
//                modifier = Modifier
//                    .clip(shape = CircleShape)
//                    .size(100.dp)
//            )
            Row(modifier = Modifier.width(90.dp)) {
                Text(
                    text = "${mecanico.nombre} ${mecanico.apellido}",
                    color = AppColors.text,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                )
            }

        }
    }

}
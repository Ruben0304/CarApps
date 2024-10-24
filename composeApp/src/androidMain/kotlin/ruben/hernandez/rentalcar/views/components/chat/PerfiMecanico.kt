package ruben.hernandez.rentalcar.views.components.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.Account
import carrental.composeapp.generated.resources.Res
import coil.compose.rememberAsyncImagePainter
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.models.Mecanico
import ruben.hernandez.rentalcar.views.poppinsFontFamily


@Preview
@Composable
fun PreviewPerf() {
    PerfilMecanico(
        Mecanico(
            "Eduardo",
            "Fonseca",
            "https://w7.pngwing.com/pngs/784/881/png-transparent-man-mechanic-emoji-icon.png"
        ),
    )
}

@Composable
@Preview
fun asyncImage(){
    val url = "https://pic.616pic.com/ys_img/01/09/35/2OKPEnNH98.jpg"

    Column(modifier = Modifier.fillMaxSize().fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = rememberAsyncImagePainter(model = url),
            contentDescription = null
        )
    }


}

@Composable
fun PerfilMecanico(
    mecanico: Mecanico, modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(end = 10.dp, bottom = 10.dp).width(100.dp).background(Color.White),
        onClick = onClick
    ) {
        Column(
            Modifier
                .background(Color.White)
                .padding(start = 2.dp, end = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = mecanico.fotoPerfil),
                contentDescription = "foto perfil",
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(100.dp)
            )
            Row(modifier = Modifier.width(90.dp)) {
                Text(
                    text = "${mecanico.nombre} ${mecanico.apellido}",
                    color = AppColors.dark,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = poppinsFontFamily
                )
            }

        }
    }

}
package ruben.hernandez.rentalcar.views.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Login
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import carrental.composeapp.generated.resources.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import carrental.composeapp.generated.resources.Account
import carrental.composeapp.generated.resources.Phone
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.profile
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import org.jetbrains.compose.resources.painterResource


@Preview
@Composable
fun ButtonProfile(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},

) {
//    BotonColorIconoDerecha/(
//        icono = painterResource(resource = Res.drawable.Account),
//        color = Color.White,
//        colorTexto =  Color(32, 31, 31, 255),
//        colorSombra = Color(14, 67, 119, 255),
//        texto = "Inicio de Sesion",
//    )



}
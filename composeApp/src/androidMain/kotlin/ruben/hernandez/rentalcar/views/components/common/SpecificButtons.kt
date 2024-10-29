package ruben.hernandez.rentalcar.views.components.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import carrental.composeapp.generated.resources.Account
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.Search
import org.jetbrains.compose.resources.painterResource


@Preview
@Composable
fun ButtonProfile(
    modifier: Modifier = Modifier,
    onClick:  () -> Unit = {},
) {
    BotonColorIconoDerecha(
        icono = painterResource(resource = Res.drawable.Account),
        color = Color.White,
        colorTexto =  Color(32, 31, 31, 255),
        colorSombra = Color(14, 67, 119, 255),
        texto = "Cuenta",
        alClic = onClick
    )
}

@Composable
fun ButtonSearch(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    BotonCircularIcono(
        modifier = modifier,
        icono = painterResource(resource = Res.drawable.Search),
        color = Color.White,
        colorIcono = Color(32, 31, 31, 255),
        colorSombra = Color(14, 67, 119, 255),
        alClic = onClick
    )
}
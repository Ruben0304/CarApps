package ruben.hernandez.rentalcar.views.components.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import carrental.composeapp.generated.resources.Account
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.Search
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors


@Preview
@Composable
fun ButtonProfile(
    modifier: Modifier = Modifier,
    onClick:  () -> Unit = {},
) {

    BotonColorIconoDerecha(
        icono = painterResource(resource = Res.drawable.Account),
        color = AppColors.principalLinearGradient,
        colorSombra = AppColors.principal,
        texto = "Cuenta",
        alClic = onClick,
        modifier = modifier
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
        colorSombra = Color(14, 67, 119, 255),
        alClic = onClick
    )
}
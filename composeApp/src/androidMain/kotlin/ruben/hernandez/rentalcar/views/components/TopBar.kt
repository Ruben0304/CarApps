package ruben.hernandez.rentalcar.views.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import carrental.composeapp.generated.resources.*
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeChild
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.navigation.Destination
import ruben.hernandez.rentalcar.navigation.DestinationP
import ruben.hernandez.rentalcar.views.components.common.BotonCircularIcono
import ruben.hernandez.rentalcar.views.components.common.BotonColorIconoDerecha
import ruben.hernandez.rentalcar.views.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class, ExperimentalHazeMaterialsApi::class)
@Composable
fun TopBar(
    navController: NavHostController? = null,
    currentRoute: String? = null,
    showBackButton: Boolean = false,
    onBackClick: (() -> Unit)? = null,
    onSearchClick: (() -> Unit)? = null // Añadimos este parámetro
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = AppColors.text
        ),
        modifier = Modifier
            .statusBarsPadding()
            .hazeChild(
                state = remember { HazeState() },
                style = HazeMaterials.thin(AppColors.buttonNav)
            ),
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = { onBackClick?.invoke() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = AppColors.text
                    )
                }
            }
        },
        title = {
            Text(
                text = currentRoute ?: "Sin ruta",
                fontSize = 18.sp,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = poppinsFontFamily
                ),
                color = AppColors.text
            )
        },
        actions = {
                BotonCircularIcono(
                    modifier = Modifier.size(38.dp),
                    icono = painterResource(resource = Res.drawable.Search),
                    colorSombra = Color(14, 67, 119, 255),
                    alClic = { onSearchClick?.invoke() }, // Usamos la nueva función
                    tamanoIcono = 17.dp
                )
                Spacer(modifier = Modifier.width(10.dp))
                BotonCircularIcono(
                    modifier = Modifier.size(38.dp),
                    icono = painterResource(resource = Res.drawable.ChatMessage),
                    colorSombra = Color(14, 67, 119, 255),
                    alClic = {},
                    tamanoIcono = 17.dp
                )
                Spacer(modifier = Modifier.width(10.dp))
                BotonColorIconoDerecha(
                    icono = painterResource(resource = Res.drawable.Account),
                    color = AppColors.principalLinearGradient,
                    colorSombra = AppColors.principal,
                    texto = "Cuenta",
                    tamanoTexto = 14.sp,
                    alClic = {},
                    forma = CircleShape,
                    altura = 38.dp,
                    tamanoIcono = 17.dp,
                    modifier = Modifier.fillMaxWidth(.38f)
                )
                Spacer(modifier = Modifier.width(10.dp))
        }
    )
}



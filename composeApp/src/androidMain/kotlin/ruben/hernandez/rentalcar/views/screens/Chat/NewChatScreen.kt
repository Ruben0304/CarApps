package ruben.hernandez.rentalcar.views.screens.Chat

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.Close
import carrental.composeapp.generated.resources.Res
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.viewModels.Chat.NewChatViewModel
import ruben.hernandez.rentalcar.views.components.car.CardCarSpecs
import ruben.hernandez.rentalcar.views.components.chat.MenuDesplegable
import ruben.hernandez.rentalcar.views.components.chat.PerfilMecanico
import ruben.hernandez.rentalcar.views.poppinsFontFamily

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun PreviewNewChat() {
    NewChatScreen()
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NewChatScreen(
    modifier: Modifier = Modifier,
    sheetState: BottomSheetState? = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed),

    ) {
    val viewModel = NewChatViewModel()
    val corrutineScope = rememberCoroutineScope()


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Seleccionar",
                fontSize = 19.sp,
                fontFamily = poppinsFontFamily
            )
            IconButton(
                onClick = {},
                modifier = Modifier.size(20.dp)
            ) {
                Icon(
                    painter = painterResource(resource = Res.drawable.Close),
                    contentDescription = "close button",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        LazyRow(
            Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items(viewModel.listMec) { item ->
                PerfilMecanico(mecanico = item,
                    onClick = {})
            }
        }

        Spacer(Modifier.height(8.dp))
        Divider()
        Spacer(Modifier.height(35.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Consulta publica",
                fontSize = 19.sp,
                fontFamily = poppinsFontFamily,
                color = AppColors.dark,
            )
        }

        Spacer(Modifier.height(35.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Provincia",
                fontSize = 17.sp,
                fontFamily = poppinsFontFamily,
                color = Color.DarkGray,
            )
            MenuDesplegable(list = viewModel.listProvincias)
        }

        Spacer(Modifier.height(35.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Text(
                    text = "Municipio",
                    fontSize = 17.sp,
                    fontFamily = poppinsFontFamily,
                    color = Color.DarkGray,
                )
                Text(
                    text = "(opcional)",
                    fontSize = 17.sp,
                    fontFamily = poppinsFontFamily,
                    color = Color.DarkGray,
                )
            }
            MenuDesplegable(list = viewModel.listMunicipios)
        }
    }
}
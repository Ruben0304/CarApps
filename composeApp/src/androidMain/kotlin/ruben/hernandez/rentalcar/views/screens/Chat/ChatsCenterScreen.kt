package ruben.hernandez.rentalcar.views.screens.Chat

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import carrental.composeapp.generated.resources.MessagingWhite
import carrental.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.viewModels.Chat.ChatCenterViewModel
import ruben.hernandez.rentalcar.viewModels.Chat.ListUiState
import ruben.hernandez.rentalcar.views.components.common.BackButton
import ruben.hernandez.rentalcar.views.components.common.BotonColor
import ruben.hernandez.rentalcar.views.components.chat.ChatsList
import ruben.hernandez.rentalcar.views.components.common.LoadingIndicator
import ruben.hernandez.rentalcar.views.components.common.SearchInput


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChatsCenterScreen(
    navController: NavController = rememberNavController(),
    viewModel: ChatCenterViewModel = ChatCenterViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
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
                    onClick = { TODO() },
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

        when (val state = uiState) {
            is ListUiState.Loading -> LoadingIndicator()
            is ListUiState.Success -> {
                ChatsList(
                listaConversaciones = state.items,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
                    .padding(end = 8.dp, start = 12.dp, top = 20.dp),
                onClick = {
                        id -> navController.navigate("chat")
                }

            )
            }
            is ListUiState.Error -> println(state.message)
        }



    }
}

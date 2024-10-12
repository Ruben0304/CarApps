package ruben.hernandez.rentalcar.views.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.views.components.BackButton
import ruben.hernandez.rentalcar.views.components.CarList
import ruben.hernandez.rentalcar.views.components.MechanicCarList
import ruben.hernandez.rentalcar.views.components.SearchInput
import ruben.hernandez.rentalcar.views.components.TopNavButton

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SearchScreen(navController: NavController ,generic: Boolean = true) {
    var selectedButton by remember { mutableStateOf(0) }
    var listado by remember { mutableStateOf(ListTypes.Auto) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.backgroundGreyWhite)
    ) {
        Row {
            BackButton(modifier = Modifier.padding(top = 20.dp, start = 15.dp), onClick = {navController.popBackStack()})
            SearchInput(
                modifier = Modifier
                    .padding(top = 20.dp, start = 10.dp, end = 15.dp)
                    .fillMaxWidth()
            )
        }

        Row(Modifier.padding(start = 25.dp, top = 30.dp, bottom = 10.dp)) {
            TopNavButton(
                onClick = { selectedButton = 0; listado = ListTypes.Auto },
                isSelected = selectedButton == 0,
                text = "Autos"
            )
            TopNavButton(
                onClick = { selectedButton = 1; listado = ListTypes.Pieza },
                isSelected = selectedButton == 1,
                text = "Piezas"
            )
            TopNavButton(
                onClick = { selectedButton = 2; listado = ListTypes.Otro },
                isSelected = selectedButton == 2,
                text = "Otros"
            )
        }

        when (listado) {
            ListTypes.Auto -> CarList()
            ListTypes.Pieza -> MechanicCarList()
            else -> {}
        }

    }
}

enum class ListTypes {
    Auto,
    Pieza,
    Otro
}
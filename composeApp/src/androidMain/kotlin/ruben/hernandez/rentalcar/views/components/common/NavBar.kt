package ruben.hernandez.rentalcar.views.components.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import carrental.composeapp.generated.resources.Home
import carrental.composeapp.generated.resources.HomeS
import carrental.composeapp.generated.resources.Key
import carrental.composeapp.generated.resources.KeyS
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.Chat
import carrental.composeapp.generated.resources.ChatS
import carrental.composeapp.generated.resources.Shopping_Bag
import carrental.composeapp.generated.resources.Shopping_BagS
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.navigation.Screen


@Composable
fun BottomNav(navController: NavController, modifier: Modifier = Modifier) {
    var selectedItem by remember { mutableStateOf(0) }

    Surface(
        shadowElevation = 25.dp,
        tonalElevation = 25.dp,
        color = Color.White,
//        border = BorderStroke(.1.dp, Color.LightGray),
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            NavItem(
                iconSelected = painterResource(Res.drawable.HomeS),
                iconUnselected = painterResource(Res.drawable.Home),
                label = "Inicio",
                isSelected = selectedItem == 0,
                onClick = { selectedItem = 0; navController.navigate(Screen.Home.route) },
                modifier = Modifier.weight(1f)
            )

            NavItem(
                iconSelected = painterResource(Res.drawable.Shopping_BagS),
                iconUnselected = painterResource(Res.drawable.Shopping_Bag),
                label = "Explorar",
                isSelected = selectedItem == 1,
                onClick = { selectedItem = 1; navController.navigate(Screen.Search.route) },
                modifier = Modifier.weight(1f)
            )

            NavItem(
                iconSelected = painterResource(Res.drawable.ChatS),
                iconUnselected = painterResource(Res.drawable.Chat),
                label = "Consultas",
                isSelected = selectedItem == 2,
                onClick = { selectedItem = 2 },
                modifier = Modifier.weight(1f)
            )

            NavItem(
                iconSelected = painterResource(Res.drawable.KeyS),
                iconUnselected = painterResource(Res.drawable.Key),
                label = "Mi auto",
                isSelected = selectedItem == 3,
                onClick = { selectedItem = 3 },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun NavItem(
    iconSelected: Painter,
    iconUnselected: Painter,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .clickable(onClick = onClick)
            .fillMaxSize()
    ) {
        val icon = if (isSelected) iconSelected else iconUnselected
        val textColor = if (isSelected) Color(80, 123, 217) else Color(165, 163, 163, 255)

        Icon(
            painter = icon,
            contentDescription = "",
            modifier = Modifier.size(25.dp),
            tint = Color.Unspecified // Deja el color sin especificar para que use el color del recurso
        )
        Text(
            text = label,
            color = textColor
        )
    }
}

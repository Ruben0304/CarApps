package ruben.hernandez.rentalcar.views.components.common

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.navigation.Screen

@Composable
fun BottomNav(navController: NavController, modifier: Modifier = Modifier) {
    var selectedItem by remember { mutableStateOf(0) }

    Surface(
//        shadowElevation = 100.dp,
//        tonalElevation = 25.dp,
        color = Color.Transparent,
        modifier = modifier
            .fillMaxWidth()
            .height(78.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth().padding(horizontal = 5.dp)
        ) {
            NavItem(
                iconSelected = painterResource(Res.drawable.HomeS),
                iconUnselected = painterResource(Res.drawable.Home),
                label = "Inicio",
                isSelected = selectedItem == 0,
                onClick = { if (selectedItem != 0) { selectedItem = 0; navController.navigate(Screen.Home.route) } },
                modifier = Modifier.weight(1f)
            )

            NavItem(
                iconSelected = painterResource(Res.drawable.Shopping_BagS),
                iconUnselected = painterResource(Res.drawable.Shopping_Bag),
                label = "Explorar",
                isSelected = selectedItem == 1,
                onClick = { if (selectedItem != 1) { selectedItem = 1;  } },
                modifier = Modifier.weight(1f)
            )

            NavItem(
                iconSelected = painterResource(Res.drawable.ChatS),
                iconUnselected = painterResource(Res.drawable.Chat),
                label = "Consultas",
                isSelected = selectedItem == 2,
                onClick = { if (selectedItem != 2) { selectedItem = 2 } },
                modifier = Modifier.weight(1f)
            )

            NavItem(
                iconSelected = painterResource(Res.drawable.KeyS),
                iconUnselected = painterResource(Res.drawable.Key),
                label = "Mi auto",
                isSelected = selectedItem == 3,
                onClick = { if (selectedItem != 3) { selectedItem = 3 } },
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
    val iconSize by animateDpAsState(targetValue = if (isSelected) 33.dp else 33.dp)
    val textColor by animateColorAsState(targetValue = if (isSelected) AppColors.text else Color.Gray)
    val interactionSource = remember { MutableInteractionSource() }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .clickable(onClick = onClick, interactionSource = interactionSource, indication = null)

    ) {
        val icon = if (isSelected) iconSelected else iconUnselected
        val iconTintColor = if (isSelected) AppColors.buttonNav else Color.Gray

        Icon(
            painter = icon,
            contentDescription = "",
            modifier = Modifier.size(iconSize),
            tint = iconTintColor // Asigna el color para iconos no seleccionados
        )

        Text(
            text = label,
            color = textColor
        )
    }
}







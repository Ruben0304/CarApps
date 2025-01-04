package ruben.hernandez.rentalcar.components.organism

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.CollapseArrow
import carrental.composeapp.generated.resources.ExpandArrow
import carrental.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors

@Composable
fun MenuDesplegable(modifier: Modifier = Modifier, list: List<String>) {
    var desplegado by remember { mutableStateOf(value = false) }
    var selected by remember { mutableStateOf(list.get(0)) }

    Column() {
        Surface(
            shape = CircleShape,
            modifier = modifier
                .width(280.dp)
                .height(37.dp)
                .background(AppColors.cardsBackground),
            shadowElevation = 5.dp,
            onClick = { desplegado = !desplegado }
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding()
                    .fillMaxSize()
                    .background(AppColors.cardsBackground),
                content = {
                    Text(
                        text = selected,
                        fontSize = 17.sp,
                        color = AppColors.text,
                        modifier = Modifier.padding(start = 20.dp)
                    )

                    if (!desplegado) {
                        Image(
                            painter = painterResource(Res.drawable.ExpandArrow),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(end = 20.dp)
                        )
                    } else {
                        Image(
                            painter = painterResource(Res.drawable.CollapseArrow),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(end = 20.dp)
                        )
                    }

                }
            )

        }
        Spacer(modifier = Modifier.height(1.dp))
        DropdownMenu(
            expanded = desplegado,
            onDismissRequest = { desplegado = false },
            modifier = Modifier
                .width(220.dp)
                .background(AppColors.cardsBackground)
        ) {
            list.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = option,
                            color = AppColors.text
                        )
                    },
                    onClick = {
                        selected = option
                        desplegado = false
                    },

                    )
            }
        }
    }
}
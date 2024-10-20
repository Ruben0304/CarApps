package ruben.hernandez.rentalcar.views.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import carrental.composeapp.generated.resources.Account
import carrental.composeapp.generated.resources.CarDoorBlue
import carrental.composeapp.generated.resources.FlightSeatBlue
import carrental.composeapp.generated.resources.GasStationBlue
import carrental.composeapp.generated.resources.GearboxBlue
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.SnowflakeBlue
import org.jetbrains.compose.resources.DrawableResource

@Composable
fun carInfoSeccion(
    passengers: Int,
    transmission: String,
    doors: Int,
    airConditioning: Boolean,
    fuelCapacity: Int,
    confortable: Boolean,
    modifierCuerpo: Modifier = Modifier,
    modifierSeccion: Modifier = Modifier,
    recurso1: Painter,
    recurso2: Painter,
    recurso3: Painter,
    recurso4: Painter,
    recurso5: Painter,
    recurso6: Painter,
    modifierRowText: Modifier = Modifier,
    modifierIcon: Modifier = Modifier,
    textStyle: TextUnit

) {
    Row(
        modifier = modifierCuerpo.fillMaxWidth().padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Column(
            modifier = modifierSeccion

        ) {
            TextInfoCar("$doors Puertas", recurso1, modifierRowText, modifierIcon, textStyle)
            TextInfoCar("$passengers Personas", recurso2, modifierRowText, modifierIcon, textStyle)

            TextInfoCar(
                "Capacidad $fuelCapacity lt", recurso5, modifierRowText, modifierIcon, textStyle
            )

        }
        Column(
            modifier = modifierSeccion
        ) {
            TextInfoCar(transmission, recurso3, modifierRowText, modifierIcon, textStyle)
            if (airConditioning) {
                TextInfoCar("Climatizado", recurso4, modifierRowText, modifierIcon, textStyle)
            }
            if (confortable) {
                TextInfoCar("Poco confortable", recurso6, modifierRowText, modifierIcon, textStyle)
            }
        }
    }
}

package ruben.hernandez.rentalcar.views.components.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.chatPromo
import carrental.composeapp.generated.resources.rent
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.components.organism.CarPromotionalCard


@Composable
fun CarrouselPromo(){
    LazyRow(
        contentPadding = PaddingValues(start = 15.dp, top = 10.dp, end = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        item{
            CarPromotionalCard(
                title = "Pregunta a mecánicos",
                imageRes = painterResource(
                    resource = Res.drawable.chatPromo
                ),
                description = "Escribele a este y al otro",
                modifier = Modifier.height(200.dp),
                onActionClick = {}
            )
        }
        item{

            CarPromotionalCard(
                title = "Renta con facilidad",
                imageRes = painterResource(
                    resource = Res.drawable.rent
                ),
                description = "renta por aqui y por alla",
                onActionClick = {},
                modifier = Modifier.height(200.dp)
            )
        }


    }
}
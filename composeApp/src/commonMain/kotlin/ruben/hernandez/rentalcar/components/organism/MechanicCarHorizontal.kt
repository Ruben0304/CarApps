package ruben.hernandez.rentalcar.components.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ruben.hernandez.rentalcar.views.components.piezas.MechanicPartCard

@Composable
fun MechanicCarHorizontal() {
    LazyRow(
        contentPadding = PaddingValues(start = 15.dp, top = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        // Lista de coches (puedes añadir más elementos aquí)
        items(5) { // ejemplo con 5 elementos
            MechanicPartCard(
                name = "Porsche 718 Cayman",
                partType = "Habana",
                imageUrl = "https://pngimg.com/d/engine_PNG20.png", // URL de la imagen
                isFavorite = false,
                onFavoriteClick = {},
                price = "$400",
                modifier = Modifier.height(230.dp).width(150.dp)

            )
        }

    }
}
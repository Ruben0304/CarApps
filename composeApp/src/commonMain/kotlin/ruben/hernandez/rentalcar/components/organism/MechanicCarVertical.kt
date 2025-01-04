package ruben.hernandez.rentalcar.components.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import ruben.hernandez.rentalcar.views.components.piezas.MechanicPartCard

@Composable
fun MechanicCarVertical() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Lista de coches (puedes añadir más elementos aquí)
        items(5) { // ejemplo con 5 elementos
            MechanicPartCard(
                name = "Porsche 718 Cayman",
                partType = "Habana",
                imageUrl = "https://pngimg.com/d/engine_PNG20.png", // URL de la imagen
                isFavorite = false,
                onFavoriteClick = {},
                price = "$400"
            )
        }

    }
}
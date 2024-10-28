package ruben.hernandez.rentalcar.views.components.piezas

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ruben.hernandez.rentalcar.AppColors
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow

import androidx.compose.material3.*

import androidx.compose.ui.draw.shadow

import coil.compose.rememberAsyncImagePainter
import ruben.hernandez.rentalcar.views.components.common.FiveStarRating
import ruben.hernandez.rentalcar.views.components.common.LikeButton
import ruben.hernandez.rentalcar.views.components.common.Rating

@Composable
fun MechanicPartCard(
    modifier: Modifier = Modifier,
    name: String,
    partType: String,
    imageUrl: String,
    price: String,
    isFavorite: Boolean = false,
    onFavoriteClick: () -> Unit
) {

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box {
            Column {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(model = imageUrl),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    LikeButton(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(8.dp),
                        onFavoriteClick = onFavoriteClick,
                        isFavorite = isFavorite
                    )

                }

                Column(
                    modifier = Modifier
                        .padding(10.dp) // Reduje el padding
                ) {
                    Text(
                        text = name,
                        fontSize = 12.sp, // Reduje el tamaño de fuente
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Filled.LocationOn,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(12.dp)
                        )
                        Text(
                            text = partType,
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = price,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = AppColors.dark,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                }
            }
            // Agregar el rating en la esquina inferior
            FiveStarRating(
                rating = 4.5f,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 10.dp, bottom = 10.dp),
                starSize = 14.dp,
                starSpacing = 2.dp
            )
        }
    }
}

@Composable
fun MechanicCarList() {
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
                modifier = Modifier.height(230.dp)

            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun Prev() {
    MechanicCarList()
}

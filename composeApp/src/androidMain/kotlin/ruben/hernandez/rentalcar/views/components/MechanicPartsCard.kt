package ruben.hernandez.rentalcar.views.components

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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow

import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow

import coil.compose.rememberAsyncImagePainter

@Composable
fun MechanicPartCard(
    name: String,
    partType: String,
    imageUrl: String,
    price: String,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit
) {
    var isLiked by remember { mutableStateOf(isFavorite) }
    val likeColor by animateColorAsState(
        if (isLiked) Color.Red else Color.Gray,
        animationSpec = tween(durationMillis = 300)
    )
    val scale by animateFloatAsState(
        targetValue = if (isLiked) 1.2f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .padding(16.dp)
            .size(180.dp, 280.dp)
            .shadow(spotColor = Color(113, 163, 248, 255), elevation = 100.dp, shape = RoundedCornerShape(16.dp)),
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
                    IconButton(
                        onClick = {
                            isLiked = !isLiked
                            onFavoriteClick()
                        },
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(8.dp)
                            .scale(scale)
                    ) {
                        Icon(
                            imageVector = if (isLiked) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = likeColor
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .padding(12.dp)
                ) {
                    Text(
                        text = name,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Filled.LocationOn,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = partType,
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = price,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = AppColors.dark,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                }
            }
        }
    }
}

@Composable
fun MechanicCarList() {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 190.dp),
        contentPadding = PaddingValues(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier.fillMaxSize()
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
        contentPadding = PaddingValues(5.dp),
//        horizontalArrangement = Arrangement.spacedBy(0.dp),
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
                price = "$400"
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun Prev() {
    MechanicCarList()
}

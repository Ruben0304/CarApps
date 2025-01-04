package ruben.hernandez.rentalcar.components.organism

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.components.util.AsyncImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CarouselImage(imagenes: List<String>, modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(initialPage = 0) {
        imagenes.size
    }
    val coroutineScope = rememberCoroutineScope()

    // Estado para forzar recomposición al cambiar de página
    val currentPage by remember { derivedStateOf { pagerState.currentPage } }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Carrusel de imágenes
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Box(
                contentAlignment = Alignment.Center, // Centrar contenido en la página
                modifier = Modifier.fillMaxSize()
            ) {
                Surface(
                    shape = RoundedCornerShape(20.dp),  // Bordes redondeados en el Surface
                    modifier = Modifier
                        .graphicsLayer { scaleX = .9f }
                        .width(400.dp)
                        .height(600.dp),
                    color = AppColors.cardsBackground,          // Fondo transparente
                    shadowElevation = 4.dp             // Sombra en Surface
                ) {
//                    AsyncImage(
//                        model = ImageRequest.Builder(LocalContext.current)
//                            .data(imagenes[currentPage])
//                            .crossfade(true)
//                            .scale(Scale.FILL)
//                            .build(),
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .clip(RoundedCornerShape(20.dp))
//                    )
                }
            }

        }


        // Indicadores de página personalizados (puntos)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(imagenes.size) { index ->
                val color = if (currentPage == index) Color.Black else Color.Gray
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(RoundedCornerShape(50))
                        .background(color)
                        .padding(horizontal = 4.dp)
                )
            }
        }
    }
}
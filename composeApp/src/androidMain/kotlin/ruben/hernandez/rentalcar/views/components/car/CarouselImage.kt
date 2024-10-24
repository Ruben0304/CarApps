package ruben.hernandez.rentalcar.views.components.car

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import androidx.compose.ui.Alignment
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import coil.size.Scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun Previa() {
    CarouselImage(
        listOf(
            "https://www.automachi.com/wp-content/uploads/2021/08/Untitled-1-3.jpg",
            "https://wallup.net/wp-content/uploads/2019/09/345133-bmw-i8-car-hybrib-future-4000x3000-748x561.jpg",
            "https://gossipvehiculo.com/wp-content/uploads/2022/03/toyota-2-1024x526.png"
        )
    )
}


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
                    color = Color.White,          // Fondo transparente
                    shadowElevation = 4.dp             // Sombra en Surface
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(imagenes[currentPage])
                            .crossfade(true)
                            .scale(Scale.FILL)
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(20.dp))
                    )
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
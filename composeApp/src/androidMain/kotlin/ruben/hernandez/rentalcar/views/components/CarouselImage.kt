package ruben.hernandez.rentalcar.views.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.error
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale


@Composable
@Preview
fun previa() {
    carouselImage(
        listOf(
            "https://www.automachi.com/wp-content/uploads/2021/08/Untitled-1-3.jpg",
            "https://wallup.net/wp-content/uploads/2019/09/345133-bmw-i8-car-hybrib-future-4000x3000-748x561.jpg",
            "https://gossipvehiculo.com/wp-content/uploads/2022/03/toyota-2-1024x526.png"
        )
    )
}


@Composable

fun carouselImage(imagenes: List<String>) {

    val pagerState = rememberPagerState(0) { imagenes.size }


    Column(
        modifier = Modifier.fillMaxSize(
        )
    ) {
        HorizontalPager(
            state = pagerState,
            beyondViewportPageCount = imagenes.size,
            contentPadding = PaddingValues(horizontal = 60.dp),
            modifier = Modifier.height(300.dp)

        ) {
            page ->
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.graphicsLayer { scaleX=0.9f }
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imagenes[page])
                        .crossfade(true)
                        .scale(Scale.FILL)
                        .build(),
                    contentDescription = null,
                    error = org.jetbrains.compose.resources.painterResource(resource = Res.drawable.error)
                )
            }
        }
    }


}

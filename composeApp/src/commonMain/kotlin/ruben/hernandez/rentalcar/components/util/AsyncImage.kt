package ruben.hernandez.rentalcar.components.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun AsyncImage(){
    val url = "https://pic.616pic.com/ys_img/01/09/35/2OKPEnNH98.jpg"

    Column(modifier = Modifier.fillMaxSize().fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
//        Image(
//            painter = rememberAsyncImagePainter(model = url),
//            contentDescription = null,
//        )
    }


}
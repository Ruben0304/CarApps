package ruben.hernandez.rentalcar.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import carrental.composeapp.generated.resources.Account
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources._1
import kotlinx.serialization.json.internal.readJson

//@Composable
//fun LottieAnimationView() {
//    val lottieJson = try {
//        Res.drawable._1
//    } catch (e: Exception) {
//        println("Error loading Lottie: ${e.message}")
//        ""
//    }
//
//    val composition by rememberLottieComposition(
//        LottieCompositionSpec.JsonString(lottieJson)
//    )
//
//    LottieAnimation(
//        composition = composition,
//        iterations = LottieConstants.IterateForever,
//        modifier = Modifier.size(200.dp)
//    )
//}
//
//@Preview
//@Composable
//fun LottieAnimationViewPreview() {
//    Box(
//        modifier = Modifier
//            .size(200.dp)
//            .background(MaterialTheme.colorScheme.background)
//    ) {
//        LottieAnimationView()
//    }
//}
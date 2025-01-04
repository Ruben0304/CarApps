package ruben.hernandez.rentalcar.components.atoms

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import carrental.composeapp.generated.resources.Facebook
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.Shape
import carrental.composeapp.generated.resources.Wrapper

@Composable
fun SocialIcons(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        listOf(Res.drawable.Wrapper, Res.drawable.Shape, Res.drawable.Facebook).forEach { icon ->
            Surface(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .size(70.dp),
                shadowElevation = 8.dp,
                color = Color.White,
                shape = CircleShape


            ) {

                Image(
                    painter = org.jetbrains.compose.resources.painterResource(resource = icon),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                )
//


            }
        }
    }
}
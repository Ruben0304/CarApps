package ruben.hernandez.rentalcar.views.components.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ruben.hernandez.rentalcar.AppColors


@Composable
fun LoadingIndicator(){// Vista de loading con CircularProgressIndicator
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.8f)
    ) {
        CircularProgressIndicator(
            strokeWidth = 7.dp,
            modifier = Modifier
                .align(Alignment.Center)
                .size(50.dp),
            color = AppColors.principal
        )
    }
}

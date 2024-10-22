package ruben.hernandez.rentalcar.views.components.common

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ruben.hernandez.rentalcar.views.poppinsFontFamily

@Composable
fun SectionHeader(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 10.dp)
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = poppinsFontFamily
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Ver más",
            fontSize = 14.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Normal,
            fontFamily = poppinsFontFamily
        )
    }
}
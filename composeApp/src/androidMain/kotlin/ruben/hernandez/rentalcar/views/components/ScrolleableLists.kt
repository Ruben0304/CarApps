package ruben.hernandez.rentalcar.views.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ruben.hernandez.rentalcar.views.poppinsFontFamily


@Composable
fun ScrolleableLists() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(top = 20.dp, bottom = 25.dp)
    ) {
        item {
            SectionHeader(title = "Recientes")
        }
        item {
            MechanicCarHorizontal()
        }
        item {
            Spacer(modifier = Modifier.height(20.dp))
        }
        item {
            SectionHeader(title = "Mejor valorados")
        }
        items(5) { index ->
            CarCard(
                carName = "Porsche 718 Cayman S",
                carType = "Coupe",
                imageUrl = "https://pngimg.com/d/maserati_PNG28.png",
                passengers = 2,
                transmission = "Manual",
                pricePerDay = "$400/d"
            )
            if (index < 4) {  // No añadir espacio después del último item
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

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
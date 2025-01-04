package ruben.hernandez.rentalcar.components.organism

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ruben.hernandez.rentalcar.components.molecules.CarBrand
import ruben.hernandez.rentalcar.components.molecules.CarBrandItem

@Composable
fun HorizontalCarBrandList(carBrands: List<CarBrand>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues( horizontal = 7.dp,vertical = 15.dp)
    ) {
        items(carBrands) { carBrand ->
            CarBrandItem(carBrand)
        }

    }
}
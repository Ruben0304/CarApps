package ruben.hernandez.rentalcar.views.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ruben.hernandez.rentalcar.views.poppinsFontFamily

@Preview
@Composable
fun previewCardSpecs() {
    cardCarSpecs(
        CarSpecs(
            "SPECS NAME",
            "SPECS VALUE",
            "SPECSUNIT"
        )
    )
}


@Composable
fun cardCarSpecs(
    carSpecs: CarSpecs

) {

    Surface(
        shape = RoundedCornerShape(18.dp),
        shadowElevation = 6.dp,
        modifier = Modifier
            .padding(end = 16.dp, top = 10.dp, bottom = 10.dp, start = 5.dp)
            .width(150.dp)
            .height(120.dp),
        color = Color.White,
    ) {
        Column(
            modifier = Modifier.padding(16.dp)

        ) {


            Text(
                text = carSpecs.specsName,
                fontSize = 14.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
            )


            Spacer(modifier = Modifier.height(18.dp))

            Row() {
                Text(
                    text = carSpecs.specsValue,
                    fontSize = 19.sp,
                    fontFamily = poppinsFontFamily,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row()
            {
                Text(
                    text = carSpecs.specsUnit,
                    fontSize = 14.sp,
                    fontFamily = poppinsFontFamily,
                    color = Color.Gray
                )
            }
        }
    }
}
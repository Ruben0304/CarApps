package ruben.hernandez.rentalcar.views.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ruben.hernandez.rentalcar.views.poppinsFontFamily

@Preview
@Composable
fun previewCardSpecs() {
    CardCarSpecs(
        CarSpecs(
            "SPECS NAME",
            "SPECS VALUE",
            "SPECSUNIT"
        )
    )
}


@Composable
fun CardCarSpecs(
    carSpecs: CarSpecs

) {

    Surface(
        shape = RoundedCornerShape(15.dp),
//        shadowElevation = 2.dp,
        modifier = Modifier
            .padding(end = 16.dp, top = 10.dp, bottom = 10.dp, start = 5.dp)
            .width(115.dp)
            .height(95.dp)
            .shadow(
                shape = RoundedCornerShape(15.dp), elevation = 6.dp, spotColor = Color(
                    88,
                    133,
                    243,
                    255
                )
            ),

        color = Color.White,
//        border = BorderStroke(.5.dp,Color.LightGray)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)

        ) {


            Text(
                text = carSpecs.specsName,
                fontSize = 12.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
            )


            Spacer(modifier = Modifier.height(8.dp))


                Text(
                    text = carSpecs.specsValue,
                    fontSize = 17.sp,
                    fontFamily = poppinsFontFamily,
                    color = Color.Black
                )

            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = carSpecs.specsUnit,
                fontSize = 14.sp,
                fontFamily = poppinsFontFamily,
                color = Color.Gray
            )
        }
    }
}
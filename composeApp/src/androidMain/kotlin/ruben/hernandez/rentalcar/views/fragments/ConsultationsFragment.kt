package ruben.hernandez.rentalcar.views.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.logo
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.views.components.common.BotonColor
import ruben.hernandez.rentalcar.views.poppinsFontFamily

@Composable
fun ConsultationsFragment(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = AppColors.backgroundGradient
                )
            )
    ) {
//        Image(painter = painterResource(resource = Res.drawable.image_),
//            contentDescription = null,)

        TextoInformativo(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxHeight(0.35f)
        )

        BotonColor(
            texto = "Nueva consulta",
            modifier = Modifier
                .fillMaxHeight(0.08f)
                .fillMaxWidth(0.8f)
                .align(alignment = Alignment.BottomCenter)
                .padding(bottom = 10.dp),
            color = AppColors.principal,
            tamanoTexto = 17.sp
        )

    }
}

@Composable
fun TextoInformativo(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            textAlign = TextAlign.Center,
            text = "Consultas publicas",
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold,
            color = AppColors.text,
            fontSize = 28.sp,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.12f),
            maxLines = 1
        )

        Spacer(modifier = Modifier.fillMaxHeight(0.15f))

        Text(
            textAlign = TextAlign.Center,
            text = "Echa un vistazo a los mecánicos y expertos en el sector automovilístico cerca de tu zona ,agenda citas con ellos y elige el que prefieras",
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.infoText,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.5f),
            maxLines = 4,
            lineHeight = 25.sp,
        )
    }


}
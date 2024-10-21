package ruben.hernandez.rentalcar.views.components

import androidx.compose.ui.graphics.Shape
import android.service.autofill.OnClickAction
import android.widget.GridView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.Phone
import carrental.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.views.poppinsFontFamily

@Composable
fun BotonColor(
    modificador: Modifier = Modifier,
    color: Color = Color(88, 133, 243, 255),
    colorTexto: Color = Color.White,
    colorSombra: Color? = null,
    icono: Painter? = null,
    texto: String = "",
    alClic: () -> Unit = {},
    tamanoTexto: TextUnit = 13.sp,
    tamanoIcono: Dp = 15.dp,
    forma: Shape = CircleShape
) {
    Button(
        onClick = alClic,
        modifier =
        if (colorSombra != null && colorSombra != Color.Black) modificador.shadow(
            elevation = 8.dp,
            shape = forma,
            spotColor = colorSombra,
            ambientColor = colorSombra
        ) else modificador,
        shape = forma,
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        ),
        elevation = if (colorSombra == Color.Black) ButtonDefaults.buttonElevation(8.dp) else ButtonDefaults.buttonElevation(0.dp)

    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            if (icono != null)
                Icon(
                    painter = icono,
                    contentDescription = "icono",
                    tint = colorTexto,
                    modifier = Modifier.size(tamanoIcono).fillMaxSize()
                )
            Text(
                text = texto,
                fontSize = tamanoTexto,
                textAlign = TextAlign.Center,
                fontFamily = poppinsFontFamily,
                modifier = Modifier.padding(horizontal = 4.dp),
                color = colorTexto
            )
        }
    }
}

@Composable
fun BotonGradiente(
    modificador: Modifier = Modifier,
    gradiente: Brush = Brush.horizontalGradient(
        listOf(
            Color(128, 120, 247, 255),
            Color(88, 133, 243, 255)
        )
    ),
    colorTexto: Color = Color.White,
    colorSombra: Color? = null,
    icono: Painter? = null,
    texto: String = "Soy botón",
    alClic: () -> Unit = {},
    tamanoTexto: TextUnit = 13.sp,
    tamanoIcono: Dp = 15.dp,
    forma: Shape = CircleShape
) {
    Button(
        onClick = alClic,
        modifier =
        if (colorSombra != null && colorSombra != Color.Black) modificador
            .shadow(
                elevation = 12.dp,
                shape = forma,
                spotColor = colorSombra,
                ambientColor = colorSombra
            )
            .background(brush = gradiente, shape = forma)
            .clip(forma) else modificador
            .background(brush = gradiente, shape = forma)
            .clip(forma),
        shape = forma,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        elevation = if (colorSombra == Color.Black) ButtonDefaults.buttonElevation(8.dp) else ButtonDefaults.buttonElevation(0.dp)

    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            if (icono != null)
                Icon(
                    painter = icono,
                    contentDescription = "icono",
                    tint = colorTexto,
                    modifier = Modifier.size(tamanoIcono)
                )
            Text(
                text = texto,
                fontSize = tamanoTexto,
                textAlign = TextAlign.Center,
                fontFamily = poppinsFontFamily,
                modifier = Modifier.padding(horizontal = 4.dp),
                color = colorTexto
            )
        }
    }
}

@Composable
fun BackButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Surface(
        onClick = onClick,
        color = Color.White,
        shape = CircleShape,
        shadowElevation = 8.dp,
        modifier = modifier

    ) {
        Icon(imageVector = Icons.Filled.ArrowBackIosNew, contentDescription = "back", tint = Color.Gray, modifier = Modifier.padding(12.dp))
    }
}

@Composable
@Preview
fun ProbarBotones() {
    Box(modifier = Modifier.fillMaxSize()) {
        Row {
            Column(Modifier.padding(20.dp)) {
                BotonColor(icono = painterResource(resource = Res.drawable.Phone))
                Spacer(modifier = Modifier.height(20.dp))
                BotonGradiente(
                    icono = painterResource(resource = Res.drawable.Phone), modificador = Modifier
                        .height(40.dp)
                        .width(140.dp)
                )
            }

            Column(Modifier.padding(20.dp)) {
                BotonColor(
                    icono = painterResource(resource = Res.drawable.Phone),
                    colorSombra = Color.Black
                )
                Spacer(modifier = Modifier.height(20.dp))
                BotonGradiente(
                    icono = painterResource(resource = Res.drawable.Phone),
                    colorSombra = Color.Black,
                    modificador = Modifier
                        .height(40.dp)
                        .width(140.dp)
                )
            }
        }
    }
}

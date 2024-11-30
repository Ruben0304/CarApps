package ruben.hernandez.rentalcar.views.components.common

import androidx.compose.ui.graphics.Shape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.Phone
import carrental.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.views.poppinsFontFamily

@Composable
fun BotonColor(
    modifier: Modifier = Modifier,
    color: Color = Color(88, 133, 243, 255),
    colorTexto: Color = AppColors.cardsBackground,
    colorSombra: Color? = null,
    icono: Painter? = null,
    texto: String = "",
    alClic: () -> Unit = {},
    tamanoTexto: TextUnit = 13.sp,
    tamanoIcono: Dp = 15.dp,
    forma: Shape = CircleShape,
    paddingtexto: Dp = 4.dp
) {
    Button(
        onClick = alClic,
        modifier =
        if (colorSombra != null && colorSombra != Color.Black) modifier.shadow(
            elevation = 8.dp,
            shape = forma,
            spotColor = colorSombra,
            ambientColor = colorSombra
        ) else modifier,
        shape = forma,
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        ),
        elevation = if (colorSombra == Color.Black) ButtonDefaults.buttonElevation(8.dp) else ButtonDefaults.buttonElevation(
            0.dp
        )

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
                    modifier = Modifier
                        .size(tamanoIcono)
                        .fillMaxSize()
                )
            Text(
                text = texto,
                fontSize = tamanoTexto,
                textAlign = TextAlign.Center,
                fontFamily = poppinsFontFamily,
                modifier = Modifier.padding(horizontal = 0.dp),
                color = colorTexto
            )
        }
    }
}

@Composable
fun BotonColorIconoDerecha(
    modifier: Modifier = Modifier,
    color: List<Color>,
    colorTexto: Color = Color.White,
    colorSombra: Color? = null,
    icono: Painter,
    texto: String = "Soy botón",
    alClic: () -> Unit = {},
    tamanoTexto: TextUnit = 15.sp,
    tamanoIcono: Dp = 20.dp,
    forma: Shape = RoundedCornerShape(8.dp),
    altura: Dp = 40.dp,
    anchura: Dp? = null
) {
    Surface(
        modifier = modifier
            .height(altura)
            .then(if (anchura != null) Modifier.width(anchura) else Modifier)
            .then(
                if (colorSombra != null) {
                    Modifier.shadow(
                        elevation = 10.dp,
                        shape = forma,
                        spotColor = colorSombra
                    )
                } else Modifier
            )
            .background(
                brush = Brush.horizontalGradient(color),
                shape = forma
            )
            .clip(forma),
        color = Color.Transparent,
        onClick = alClic

    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = texto,
                fontSize = tamanoTexto,
                color = colorTexto,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Icon(
                painter = icono,
                contentDescription = texto,
                tint = colorTexto,
                modifier = Modifier.size(tamanoIcono)
            )
        }
    }
}

@Composable
fun BotonCircularIcono(
    modifier: Modifier = Modifier,
    color: Color = AppColors.cardsBackground,
    colorIcono: Color = AppColors.text,
    colorSombra: Color? = null,
    icono: Painter,
    alClic: () -> Unit = {},
    tamanoIcono: Dp = 20.dp
) {
    Button(
        onClick = alClic,
        modifier = if (colorSombra != null && colorSombra != Color.Black)
            modifier
                .shadow(
                    elevation = 5.dp,
                    shape = CircleShape,
                )
                .height(40.dp)
        else modifier,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        ),
        elevation = if (colorSombra == Color.Black)
            ButtonDefaults.buttonElevation(8.dp)
        else ButtonDefaults.buttonElevation(0.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        Icon(
            painter = icono,
            contentDescription = "icono de búsqueda",
            tint = colorIcono,
            modifier = Modifier.size(tamanoIcono)
        )
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
    colorTexto: Color = AppColors.cardsBackground,
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
        elevation = if (colorSombra == Color.Black) ButtonDefaults.buttonElevation(8.dp) else ButtonDefaults.buttonElevation(
            0.dp
        )

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
        Icon(
            imageVector = Icons.Filled.ArrowBackIosNew,
            contentDescription = "back",
            tint = Color.Gray,
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Composable
fun MapButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    icono: Painter
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .background(color, shape = CircleShape)


    ) {
        Icon(
            painter = icono,
            contentDescription = "map",
            tint = AppColors.cardsBackground,
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Composable
fun ButtonNotBackground(
    modificador: Modifier = Modifier,
    color: Color = Color(88, 133, 243, 255),
    colorTexto: Color = AppColors.cardsBackground,
    colorSombra: Color? = null,
    icono: Painter? = null,
    texto: String = "Soy botón",
    alClic: () -> Unit = {},
    tamanoTexto: TextUnit = 13.sp,
    tamanoIcono: Dp = 15.dp,
    forma: Shape = CircleShape,
    border: BorderStroke = ButtonDefaults.outlinedButtonBorder(true),
) {
    OutlinedButton(
        onClick = alClic,
        border = border,
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
        elevation = if (colorSombra == Color.Black) ButtonDefaults.buttonElevation(8.dp) else ButtonDefaults.buttonElevation(
            0.dp
        )

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

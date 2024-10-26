package ruben.hernandez.rentalcar.views.components.mechanic
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Star
//import androidx.compose.material3.HorizontalDivider
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import org.jetbrains.compose.resources.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import carrental.composeapp.generated.resources.Conflict
//import carrental.composeapp.generated.resources.MessagingWhite
//import carrental.composeapp.generated.resources.Phone
//import carrental.composeapp.generated.resources.Res
//import carrental.composeapp.generated.resources.mecanica
//import coil.compose.rememberImagePainter
//import ruben.hernandez.rentalcar.AppColors
//import ruben.hernandez.rentalcar.views.components.common.BotonColor
//import ruben.hernandez.rentalcar.views.poppinsFontFamily
//
//@Composable
//fun MechanicCard(modifier: Modifier = Modifier) {
//    Card(
//        shape = RoundedCornerShape(30.dp),
//        elevation = 6.dp,
//        modifier = modifier
//    ) {
//        Box {
//
//
//            Column {
//                // Image Section
//                Image(
//                    painter = painterResource(resource = Res.drawable.mecanica),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(250.dp)
//                )
//
//                Spacer(modifier = Modifier.height(4.dp))
//
//                // Text Section
//                Column(modifier = Modifier.padding(vertical = 16.dp, horizontal = 28.dp)) {
//                    Text(
//                        text = "Alberta Mecánica",
//                        fontFamily = poppinsFontFamily,
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 20.sp
//                    )
//
//                    Spacer(modifier = Modifier.height(4.dp))
//
//                    Text(
//                        text = "calle 166 5ta/1ra #110",
//                        style = MaterialTheme.typography.body2,
//                        color = Color.Gray
//                    )
//
//                    HorizontalDivider(
//                        modifier = Modifier
//                            .padding(vertical = 15.dp),
//                        color = Color(
//                            231,
//                            229,
//                            229,
//                            210
//                        ) // Puedes personalizar el color también si lo deseas
//                    )
//
//
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//
//                        ) {
//                        Row(
//                            verticalAlignment = Alignment.CenterVertically,
//                            modifier = Modifier.weight(1f)
//                        ) {
//
//                            Icon(
//                                painter = painterResource(resource = Res.drawable.Conflict), // Placeholder for your icon
//                                contentDescription = "Especialidad",
//                                tint = AppColors.principal,
//                                modifier = Modifier.size(28.dp)
//                            )
//                            Spacer(modifier = Modifier.width(8.dp))
//
//                            Text(
//                                text = "Electricista",
//                                fontSize = 16.sp,
//                                fontFamily = poppinsFontFamily,
//                                color = AppColors.dark
//                            )
//
//
//                        }
//
//                        BotonColor(
//                            texto = "Escribir",
//                            icono = painterResource(resource = Res.drawable.MessagingWhite),
//                            colorTexto = Color.White,
//                            color = AppColors.principal.copy(.9f),
//                            tamanoTexto = 16.sp,
//                            tamanoIcono = 20.dp
//
//                        )
//
////
//
//                    }
//                }
//            }
//            androidx.compose.material3.Surface(
//                color = Color(0xFFF2E6D3),
//                shape = CircleShape,
//                modifier = Modifier
//                    .align(Alignment.TopEnd)
//                    .padding(12.dp)
//            ) {
//
//
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 18.dp)
//
//                ) {
//                    Icon(
//                        imageVector = Icons.Filled.Star,
//                        contentDescription = "Rating",
//                        tint = Color(0xFFFFC107), // Color amarillo de la estrella
//                        modifier = Modifier.size(22.dp)
//                    )
//                    Spacer(modifier = Modifier.width(6.dp))
//                    Text(
//                        text = "4.3",
//                        fontFamily = poppinsFontFamily,
//                        fontSize = 15.sp,
//                        fontWeight = FontWeight.W500,
//                        color = Color(43, 38, 38) // Color del texto
//                    )
//                    Spacer(modifier = Modifier.width(6.dp))
//                }
//            }
//        }
//    }
//}
//
//@Preview
//@Composable
//fun PreviewMechanicCard() {
//    Column(modifier = Modifier.fillMaxWidth()) {
//        MechanicCard(modifier = Modifier.fillMaxWidth(.9f).align(Alignment.CenterHorizontally).padding(vertical = 12.dp))
//    }
//
//}


import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.Conflict
import carrental.composeapp.generated.resources.MessagingWhite
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.mecanica
import androidx.compose.material3.Surface
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

import coil.compose.rememberImagePainter
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.views.components.common.BackButton
import ruben.hernandez.rentalcar.views.components.common.BotonColor
import ruben.hernandez.rentalcar.views.poppinsFontFamily

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MechanicCard(
    modifier: Modifier = Modifier,
    isExpanded: Boolean,
    onCardClick: () -> Unit
) {


    val screenHeight = LocalConfiguration.current.screenHeightDp.dp // Altura de la pantalla en dp
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val animationDuration = 200 // Duración de la animación en milisegundos

    // Ajusta la duración de las animaciones
    val cardHeight by animateDpAsState(
        targetValue = if (isExpanded) screenHeight else 440.dp,
        animationSpec = tween(durationMillis = animationDuration)
    )
    val cardWidth by animateDpAsState(
        targetValue = if (isExpanded) screenWidth else (screenWidth.value * 0.96f).dp,
        animationSpec = tween(durationMillis = animationDuration)
    )
    val cardElevation by animateDpAsState(
        targetValue = if (isExpanded) 0.dp else 6.dp,
        animationSpec = tween(durationMillis = animationDuration)
    )
    val cardRounded by animateDpAsState(
        targetValue = if (isExpanded) 0.dp else 30.dp,
        animationSpec = tween(durationMillis = animationDuration)
    )
    val padding by animateDpAsState(
        targetValue = if (isExpanded) 0.dp else 12.dp,
        animationSpec = tween(durationMillis = animationDuration)
    )


    Box(modifier = Modifier.fillMaxSize()) {
        val interactionSource = remember { MutableInteractionSource() }
        val pressed by interactionSource.collectIsPressedAsState()
        val haptic = LocalHapticFeedback.current

        Card(
            shape = RoundedCornerShape(cardRounded),
            elevation = cardElevation,
            modifier = modifier
                .height(cardHeight)
                .width(cardWidth)
                .padding(padding)
                .indication(interactionSource, null)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    if (!isExpanded) {
                        onCardClick()
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    }
                }
                .draggable(
                    orientation = Orientation.Vertical,
                    interactionSource = interactionSource,
                    state = rememberDraggableState { delta ->
                        if (delta > 0) {
                            if (isExpanded) {// Si se arrastra hacia abajo
                                onCardClick()
                                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                            }
                        }
                    }
                )

        )// Usa tu propia interacción

        {
            Box {
                Column {
                    // Sección de imagen
                    Image(
                        painter = painterResource(resource = Res.drawable.mecanica),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(if (isExpanded) 350.dp else 250.dp)
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    // Sección de texto
                    Column(modifier = Modifier.padding(vertical = 16.dp, horizontal = 28.dp)) {
                        Text(
                            text = "Alberta Mecánica",
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "calle 166 5ta/1ra #110",
                            style = MaterialTheme.typography.body2,
                            color = Color.Gray
                        )

                        HorizontalDivider(
                            modifier = Modifier
                                .padding(vertical = 15.dp),
                            color = Color(
                                231,
                                229,
                                229,
                                210
                            )
                        )

                        if (isExpanded)
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 100.dp)
                                    .verticalScroll(rememberScrollState())
                            ) {
                                Text(
                                    text = buildAnnotatedString {
                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                            append("Descripción: ")
                                        }
                                        append("Ernesto Pérez, un mecánico con más de 20 años de experiencia, te ofrece su taller en el corazón del municipio Playa, La Habana.\n\n")
                                        append("Ernesto es conocido por su pasión por los automóviles y su compromiso con la excelencia. Cada reparación que realiza es un testimonio de su dedicación y su profundo conocimiento de la mecánica. Desde la reparación de motores y transmisiones hasta el mantenimiento regular y la solución de problemas eléctricos, Ernesto se especializa en todo tipo de vehículos, incluyendo coches clásicos y modernos.\n\n")
                                        append("Además de su habilidad técnica, Ernesto se destaca por su trato amable y atención al cliente. Entiende la importancia de la confianza en este negocio y siempre se asegura de mantener a sus clientes informados sobre cada paso del proceso de reparación. Su transparencia y honestidad han ganado el corazón de la comunidad local.\n\n")
                                        append("En el taller de Ernesto, no solo encontrarás un servicio técnico de primera, sino también un lugar donde se valora la integridad y la relación a largo plazo con los clientes. Ya sea que necesites una revisión rutinaria o una reparación compleja, Ernesto y su equipo están listos para ayudarte a mantener tu vehículo en perfecto estado. Tu satisfacción es su prioridad.")
                                    },
                                    style = MaterialTheme.typography.body1
                                )


                            }

                    }
                }
                if (isExpanded)
                    Row(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(
                                horizontal = 28.dp,
                                vertical = 20.dp
                            )
                    ) {
                        BackButton(
                            onClick = onCardClick,
                            modifier = Modifier
                                .size(40.dp)


                        )
                    }

                Surface(
                    color = Color(0xFFF2E6D3),
                    shape = CircleShape,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(
                            horizontal = 28.dp,
                            vertical = 20.dp
                        )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 18.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "Rating",
                            tint = Color(0xFFFFC107),
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "4.3",
                            fontFamily = poppinsFontFamily,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.W500,
                            color = Color(43, 38, 38)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                    }
                }
                Surface(
                    shape = RoundedCornerShape(30.dp),
//                    shadowElevation = if (isExpanded) 3.dp else 0.dp,
                    color = Color.White,
//                    color = if (isExpanded) Color(180, 194, 221, 62) else Color.Transparent,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(horizontal = 12.dp, vertical = if (isExpanded) 20.dp else 0.dp)
                        .height(80.dp)

                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 28.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                painter = painterResource(resource = Res.drawable.Conflict),
                                contentDescription = "Especialidad",
                                tint = AppColors.principal,
                                modifier = Modifier.size(28.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Electricista",
                                fontSize = 17.sp,
                                fontFamily = poppinsFontFamily,
                                color = AppColors.dark
                            )
                        }

                        BotonColor(
                            texto = "Escribir",
                            icono = painterResource(resource = Res.drawable.MessagingWhite),
                            colorTexto = Color.White,
                            color = AppColors.principal.copy(.9f),
                            tamanoTexto = 16.sp,
                            tamanoIcono = 20.dp,
                            modifier = Modifier.height(if (isExpanded) 50.dp else 45.dp)
                        )

                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MechanicCardScreen() {
    var isExpanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        MechanicCard(
            modifier = Modifier.align(Alignment.TopCenter),
            isExpanded = isExpanded,
            onCardClick = { isExpanded = !isExpanded }
        )
    }
}


@Preview
@Composable
fun PreviewMechanicCardScreen() {
    MechanicCardScreen()
}

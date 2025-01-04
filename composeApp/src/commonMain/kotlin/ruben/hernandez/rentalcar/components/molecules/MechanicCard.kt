//package ruben.hernandez.rentalcar.components.molecules
//
//import androidx.compose.animation.core.animateDpAsState
//import androidx.compose.animation.core.tween
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.gestures.Orientation
//import androidx.compose.foundation.gestures.draggable
//import androidx.compose.foundation.gestures.rememberDraggableState
//import androidx.compose.foundation.indication
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Card
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.Icon
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Text
//import androidx.compose.material3.HorizontalDivider
//import androidx.compose.material3.Surface
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.hapticfeedback.HapticFeedbackType
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalHapticFeedback
//import androidx.compose.ui.text.SpanStyle
//import androidx.compose.ui.text.buildAnnotatedString
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.withStyle
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import carrental.composeapp.generated.resources.Conflict
//import carrental.composeapp.generated.resources.MessagingWhite
//import carrental.composeapp.generated.resources.Res
//import carrental.composeapp.generated.resources.mecanica
//import org.jetbrains.compose.resources.painterResource
//import ruben.hernandez.rentalcar.AppColors
//import ruben.hernandez.rentalcar.views.components.common.BackButton
//import ruben.hernandez.rentalcar.views.components.common.BotonColor
//import ruben.hernandez.rentalcar.views.components.common.Rating
//
//@Composable
//fun MechanicCard(
//    modifier: Modifier = Modifier,
//    isExpanded: Boolean,
//    onCardClick: () -> Unit
//) {
//
//
//    val screenHeight = LocalConfiguration.current.screenHeightDp.dp // Altura de la pantalla en dp
//    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
//    val animationDuration = 200 // Duración de la animación en milisegundos
//
//    // Ajusta la duración de las animaciones
//    val cardHeight by animateDpAsState(
//        targetValue = if (isExpanded) screenHeight else 440.dp,
//        animationSpec = tween(durationMillis = animationDuration)
//    )
//    val cardWidth by animateDpAsState(
//        targetValue = if (isExpanded) screenWidth else (screenWidth.value * 0.96f).dp,
//        animationSpec = tween(durationMillis = animationDuration)
//    )
//    val cardElevation by animateDpAsState(
//        targetValue = if (isExpanded) 0.dp else 6.dp,
//        animationSpec = tween(durationMillis = animationDuration)
//    )
//    val cardRounded by animateDpAsState(
//        targetValue = if (isExpanded) 0.dp else 30.dp,
//        animationSpec = tween(durationMillis = animationDuration)
//    )
//    val padding by animateDpAsState(
//        targetValue = if (isExpanded) 0.dp else 12.dp,
//        animationSpec = tween(durationMillis = animationDuration)
//    )
//
//    val hazeState = remember { HazeState() }
//
//
//    Box(modifier = Modifier.fillMaxSize()) {
//        val interactionSource = remember { MutableInteractionSource() }
//        val haptic = LocalHapticFeedback.current
//
//        Card(
//            shape = RoundedCornerShape(cardRounded),
//            elevation = cardElevation,
//            modifier = modifier
//                .height(cardHeight)
//                .width(cardWidth)
//                .padding(padding)
//                .indication(interactionSource, null)
//                .clickable(
//                    interactionSource = interactionSource,
//                    indication = null
//                ) {
//                    if (!isExpanded) {
//                        onCardClick()
//                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
//                    }
//                }
//                .draggable(
//                    orientation = Orientation.Vertical,
//                    interactionSource = interactionSource,
//                    state = rememberDraggableState { delta ->
//                        if (delta > 0) {
//                            if (isExpanded) {// Si se arrastra hacia abajo
//                                onCardClick()
//                                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
//                            }
//                        }
//                    }
//                )
//
//        )// Usa tu propia interacción
//
//        {
//            Box {
//                Column {
//                    // Sección de imagen
//                    Image(
//                        painter = painterResource(resource = Res.drawable.mecanica),
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(if (isExpanded) 350.dp else 250.dp)
//                    )
//
//                    Spacer(modifier = Modifier.height(4.dp))
//
//                    // Sección de texto
//                    Column(modifier = Modifier.padding(vertical = 16.dp, horizontal = 18.dp)) {
//                        Text(
//                            text = "Alberta Mecánica",
//                            fontWeight = FontWeight.Bold,
//                            fontSize = 20.sp
//                        )
//
//                        Spacer(modifier = Modifier.height(4.dp))
//
//                        Text(
//                            text = "calle 166 5ta/1ra #110",
//                            style = MaterialTheme.typography.body2,
//                            color = Color.Gray
//                        )
//
//                        HorizontalDivider(
//                            modifier = Modifier
//                                .padding(vertical = 10.dp),
//                            color = Color(
//                                231,
//                                229,
//                                229,
//                                210
//                            )
//                        )
//
//                        if (isExpanded)
//                            LazyColumn(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .haze(state = hazeState)
//
//                            ) {
//                                item {
//                                    Text(
//                                        text = buildAnnotatedString {
//                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
//                                                append("Descripción: ")
//                                            }
//                                            append("Ernesto Pérez, un mecánico con más de 20 años de experiencia, te ofrece su taller en el corazón del municipio Playa, La Habana.\n\n")
//                                            append("Ernesto es conocido por su pasión por los automóviles y su compromiso con la excelencia. Cada reparación que realiza es un testimonio de su dedicación y su profundo conocimiento de la mecánica. Desde la reparación de motores y transmisiones hasta el mantenimiento regular y la solución de problemas eléctricos, Ernesto se especializa en todo tipo de vehículos, incluyendo coches clásicos y modernos.\n\n")
//                                            append("Además de su habilidad técnica, Ernesto se destaca por su trato amable y atención al cliente. Entiende la importancia de la confianza en este negocio y siempre se asegura de mantener a sus clientes informados sobre cada paso del proceso de reparación. Su transparencia y honestidad han ganado el corazón de la comunidad local.\n\n")
//                                            append("En el taller de Ernesto, no solo encontrarás un servicio técnico de primera, sino también un lugar donde se valora la integridad y la relación a largo plazo con los clientes. Ya sea que necesites una revisión rutinaria o una reparación compleja, Ernesto y su equipo están listos para ayudarte a mantener tu vehículo en perfecto estado. Tu satisfacción es su prioridad.")
//                                        },
//                                        style = MaterialTheme.typography.body1
//                                    )
//                                }
//
//
//                            }
//
//                    }
//                }
//                if (isExpanded)
//                    Row(
//                        modifier = Modifier
//                            .align(Alignment.TopStart)
//                            .padding(
//                                horizontal = 28.dp,
//                                vertical = 20.dp
//                            )
//                    ) {
//                        BackButton(
//                            onClick = onCardClick,
//                            modifier = Modifier
//                                .size(40.dp)
//
//
//                        )
//                    }
//
//                Rating(
//                    rating = 4.3f, modifier = Modifier
//                        .align(Alignment.TopEnd)
//                        .padding(
//                            horizontal = 28.dp,
//                            vertical = 20.dp
//                        )
//                )
//                Surface(
//                    color = if (isExpanded) Color(192, 177, 177, 111) else Color.Transparent,
//                    shape = RoundedCornerShape(15.dp),
//                    modifier = Modifier
//                        .align(Alignment.BottomCenter)
//                        .padding(
//                            horizontal = if (isExpanded) 10.dp else 5.dp,
//                            vertical = if (isExpanded) 20.dp else 10.dp
//                        )
//                        .height(65.dp)
//                        .hazeChild(
//                            state = hazeState,
//                            shape = RoundedCornerShape(15.dp)
//                        )
//
//                ) {
//                    Row(
//                        modifier = Modifier.padding(horizontal = 18.dp),
//                        verticalAlignment = Alignment.CenterVertically,
//                    ) {
//
//                        Row(
//                            verticalAlignment = Alignment.CenterVertically,
//                            modifier = Modifier.weight(1f)
//                        ) {
//                            Icon(
//                                painter = painterResource(resource = Res.drawable.Conflict),
//                                contentDescription = "Especialidad",
//                                tint = AppColors.principal,
//                                modifier = Modifier.size(25.dp)
//                            )
//                            Spacer(modifier = Modifier.width(8.dp))
//
//                            Text(
//                                text = "Electricista",
//                                fontSize = 16.sp,
//                                color = AppColors.text
//                            )
//                        }
//
//                        BotonColor(
//                            texto = "Escribir",
//                            icono = painterResource(resource = Res.drawable.MessagingWhite),
//                            colorTexto = AppColors.cardsBackground,
//                            color = AppColors.principal,
//                            tamanoTexto = 16.sp,
//                            tamanoIcono = 20.dp,
//                            modifier = Modifier.height(45.dp)
//                        )
//
//                    }
//                }
//            }
//        }
//    }
//}
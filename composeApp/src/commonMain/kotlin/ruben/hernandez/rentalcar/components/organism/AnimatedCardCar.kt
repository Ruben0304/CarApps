//package ruben.hernandez.rentalcar.components.organism
//
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.animation.core.FastOutSlowInEasing
//import androidx.compose.animation.core.animateDpAsState
//import androidx.compose.animation.core.animateFloatAsState
//import androidx.compose.animation.core.tween
//import androidx.compose.animation.expandVertically
//import androidx.compose.animation.fadeIn
//import androidx.compose.animation.fadeOut
//import androidx.compose.animation.shrinkVertically
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.offset
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material.icons.filled.FavoriteBorder
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material.icons.filled.Settings
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.graphicsLayer
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.ui.zIndex
//import ruben.hernandez.rentalcar.AppColors
//import ruben.hernandez.rentalcar.components.util.AsyncImage
//
//@Composable
//fun AnimatedCarCard(
//    carName: String,
//    carType: String,
//    imageUrl: String,
//    passengers: Int,
//    transmission: String,
//    pricePerDay: String,
//    isExpanded: Boolean,
//    onExpand: () -> Unit,
//    onCollapse: () -> Unit,
//    onFavoriteClick: () -> Unit = {}
//) {
//    val configuration = LocalConfiguration.current
//    val screenHeight = configuration.screenHeightDp.dp
//    val screenWidth = configuration.screenWidthDp.dp
//
//    val animatedScale by animateFloatAsState(
//        targetValue = if (isExpanded) 1f else 0.9f,
//        animationSpec = tween(500, easing = FastOutSlowInEasing)
//    )
//
//    val animatedCornerRadius by animateDpAsState(
//        targetValue = if (isExpanded) 0.dp else 18.dp,
//        animationSpec = tween(500, easing = FastOutSlowInEasing)
//    )
//
//    val animatedOffset by animateDpAsState(
//        targetValue = if (isExpanded) 0.dp else 16.dp,
//        animationSpec = tween(500, easing = FastOutSlowInEasing)
//    )
//
//    val animatedHeight by animateDpAsState(
//        targetValue = if (isExpanded) screenHeight else 280.dp,
//        animationSpec = tween(500, easing = FastOutSlowInEasing)
//    )
//
//    val animatedWidth by animateDpAsState(
//        targetValue = if (isExpanded) screenWidth else (screenWidth - 32.dp),
//        animationSpec = tween(500, easing = FastOutSlowInEasing)
//    )
//
//    val animatedPositionX by animateDpAsState(
//        targetValue = if (isExpanded) (-16).dp else 0.dp,
//        animationSpec = tween(500, easing = FastOutSlowInEasing)
//    )
//
//    val animatedPositionY by animateDpAsState(
//        targetValue = if (isExpanded) (-16).dp else 0.dp,
//        animationSpec = tween(500, easing = FastOutSlowInEasing)
//    )
//
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(if (isExpanded) screenHeight else 280.dp)
//            .offset(x = animatedPositionX, y = animatedPositionY)
//            .zIndex(if (isExpanded) 1f else 0f)
//    ) {
//        Surface(
//            shape = RoundedCornerShape(animatedCornerRadius),
//            shadowElevation = if (isExpanded) 0.dp else 6.dp,
//            modifier = Modifier
//                .width(animatedWidth)
//                .height(animatedHeight)
//                .align(if (isExpanded) Alignment.TopStart else Alignment.Center)
//                .graphicsLayer {
//                    scaleX = animatedScale
//                    scaleY = animatedScale
//                }
//                .clickable(enabled = !isExpanded) { onExpand() },
//            color = AppColors.cardsBackground
//        ) {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(AppColors.cardsBackground)
//            ) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(16.dp)
//                        .verticalScroll(rememberScrollState())
//                ) {
//                    // Header con botón de cierre cuando está expandido
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceBetween,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        if (isExpanded) {
//                            IconButton(
//                                onClick = onCollapse,
//                                modifier = Modifier.padding(end = 8.dp)
//                            ) {
//                                Icon(
//                                    imageVector = Icons.Default.ArrowBack,
//                                    contentDescription = "Back"
//                                )
//                            }
//                        }
//
//                        Column(modifier = Modifier.weight(1f)) {
//                            Text(
//                                text = carName,
//                                fontSize = if (isExpanded) 24.sp else 20.sp,
//                                fontWeight = FontWeight.Bold,
//                                color = AppColors.text
//                            )
//                            Text(
//                                text = carType,
//                                fontSize = if (isExpanded) 16.sp else 14.sp,
//                                color = Color.Gray
//                            )
//                        }
//
//                        if (!isExpanded) {
//                            IconButton(onClick = onFavoriteClick) {
//                                Icon(
//                                    imageVector = Icons.Default.FavoriteBorder,
//                                    contentDescription = "Favorite"
//                                )
//                            }
//                        }
//                    }
//
//                    Spacer(modifier = Modifier.height(8.dp))
//
////                    AsyncImage(
////                        model = imageUrl,
////                        contentDescription = null,
////                        modifier = Modifier
////                            .fillMaxWidth()
////                            .height(if (isExpanded) 300.dp else 150.dp),
////                        contentScale = ContentScale.Fit
////                    )
//
//                    Spacer(modifier = Modifier.height(8.dp))
//
//                    // Detalles del coche
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                        modifier = Modifier.fillMaxWidth()
//                    ) {
//                        Icon(
//                            imageVector = Icons.Default.Person,
//                            contentDescription = null,
//                            tint = Color.Gray,
//                            modifier = Modifier.size(20.dp)
//                        )
//                        Text(
//                            text = "$passengers",
//                            modifier = Modifier.padding(start = 4.dp, end = 16.dp),
//                            fontSize = if (isExpanded) 16.sp else 14.sp
//                        )
//
//                        Icon(
//                            imageVector = Icons.Default.Settings,
//                            contentDescription = null,
//                            tint = Color.Gray,
//                            modifier = Modifier.size(20.dp)
//                        )
//                        Text(
//                            text = transmission,
//                            modifier = Modifier.padding(start = 4.dp),
//                            fontSize = if (isExpanded) 16.sp else 14.sp,
//                            color = AppColors.text
//                        )
//                        Spacer(modifier = Modifier.weight(1f))
//
//                        Text(
//                            text = pricePerDay,
//                            fontSize = if (isExpanded) 22.sp else 18.sp,
//                            fontWeight = FontWeight.Bold,
//                            textAlign = TextAlign.End
//                        )
//                    }
//
//                    // Contenido adicional cuando está expandido
//                    AnimatedVisibility(
//                        visible = isExpanded,
//                        enter = fadeIn() + expandVertically(),
//                        exit = fadeOut() + shrinkVertically()
//                    ) {
//                        Column(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(top = 16.dp)
//                        ) {
//                            Text(
//                                text = "Descripción detallada",
//                                fontSize = 20.sp,
//                                fontWeight = FontWeight.Bold
//                            )
//                            Spacer(modifier = Modifier.height(8.dp))
//                            Text(
//                                text = "Descubre la experiencia única de conducir este vehículo excepcional. " +
//                                        "Con su diseño elegante y rendimiento superior, este modelo combina " +
//                                        "perfectamente estilo y funcionalidad.",
//                                fontSize = 16.sp,
//                                lineHeight = 24.sp
//                            )
//
//                            Spacer(modifier = Modifier.height(24.dp))
//
//                            Button(
//                                onClick = { /* Reservar */ },
//                                modifier = Modifier.fillMaxWidth(),
//                                colors = ButtonDefaults.buttonColors(
//                                    containerColor = MaterialTheme.colorScheme.primary
//                                )
//                            ) {
//                                Text(
//                                    text = "Reservar ahora",
//                                    fontSize = 18.sp,
//                                    modifier = Modifier.padding(vertical = 8.dp)
//                                )
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
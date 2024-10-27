package ruben.hernandez.rentalcar.views.components.car

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.ui.tooling.preview.Preview
import carrental.composeapp.generated.resources.Gearbox
import carrental.composeapp.generated.resources.Res
import coil.compose.rememberAsyncImagePainter
import org.jetbrains.compose.resources.painterResource
import ruben.hernandez.rentalcar.views.components.common.LikeButton
import ruben.hernandez.rentalcar.views.poppinsFontFamily

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

import androidx.compose.animation.core.*
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage

// Primero, creamos un estado compartido para controlar la expansión
object CardExpansionState {
    var isAnyCardExpanded = mutableStateOf(false)
}



@Composable
fun AnimatedCarCard(
    carName: String,
    carType: String,
    imageUrl: String,
    passengers: Int,
    transmission: String,
    pricePerDay: String,
    isExpanded: Boolean,
    onExpand: () -> Unit,
    onCollapse: () -> Unit,
    onFavoriteClick: () -> Unit = {}
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    val animatedScale by animateFloatAsState(
        targetValue = if (isExpanded) 1f else 0.9f,
        animationSpec = tween(500, easing = FastOutSlowInEasing)
    )

    val animatedCornerRadius by animateDpAsState(
        targetValue = if (isExpanded) 0.dp else 18.dp,
        animationSpec = tween(500, easing = FastOutSlowInEasing)
    )

    val animatedOffset by animateDpAsState(
        targetValue = if (isExpanded) 0.dp else 16.dp,
        animationSpec = tween(500, easing = FastOutSlowInEasing)
    )

    val animatedHeight by animateDpAsState(
        targetValue = if (isExpanded) screenHeight else 280.dp,
        animationSpec = tween(500, easing = FastOutSlowInEasing)
    )

    val animatedWidth by animateDpAsState(
        targetValue = if (isExpanded) screenWidth else (screenWidth - 32.dp),
        animationSpec = tween(500, easing = FastOutSlowInEasing)
    )

    val animatedPositionX by animateDpAsState(
        targetValue = if (isExpanded) (-16).dp else 0.dp,
        animationSpec = tween(500, easing = FastOutSlowInEasing)
    )

    val animatedPositionY by animateDpAsState(
        targetValue = if (isExpanded) (-16).dp else 0.dp,
        animationSpec = tween(500, easing = FastOutSlowInEasing)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(if (isExpanded) screenHeight else 280.dp)
            .offset(x = animatedPositionX, y = animatedPositionY)
            .zIndex(if (isExpanded) 1f else 0f)
    ) {
        Surface(
            shape = RoundedCornerShape(animatedCornerRadius),
            shadowElevation = if (isExpanded) 0.dp else 6.dp,
            modifier = Modifier
                .width(animatedWidth)
                .height(animatedHeight)
                .align(if (isExpanded) Alignment.TopStart else Alignment.Center)
                .graphicsLayer {
                    scaleX = animatedScale
                    scaleY = animatedScale
                }
                .clickable(enabled = !isExpanded) { onExpand() },
            color = Color.White
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    // Header con botón de cierre cuando está expandido
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (isExpanded) {
                            IconButton(
                                onClick = onCollapse,
                                modifier = Modifier.padding(end = 8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBackIosNew,
                                    contentDescription = "Back"
                                )
                            }
                        }

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = carName,
                                fontSize = if (isExpanded) 24.sp else 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = carType,
                                fontSize = if (isExpanded) 16.sp else 14.sp,
                                color = Color.Gray
                            )
                        }

                        if (!isExpanded) {
                            IconButton(onClick = onFavoriteClick) {
                                Icon(
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = "Favorite"
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    AsyncImage(
                        model = imageUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(if (isExpanded) 300.dp else 150.dp),
                        contentScale = ContentScale.Fit
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Detalles del coche
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "$passengers",
                            modifier = Modifier.padding(start = 4.dp, end = 16.dp),
                            fontSize = if (isExpanded) 16.sp else 14.sp
                        )

                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = transmission,
                            modifier = Modifier.padding(start = 4.dp),
                            fontSize = if (isExpanded) 16.sp else 14.sp
                        )
                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = pricePerDay,
                            fontSize = if (isExpanded) 22.sp else 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End
                        )
                    }

                    // Contenido adicional cuando está expandido
                    AnimatedVisibility(
                        visible = isExpanded,
                        enter = fadeIn() + expandVertically(),
                        exit = fadeOut() + shrinkVertically()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp)
                        ) {
                            Text(
                                text = "Descripción detallada",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Descubre la experiencia única de conducir este vehículo excepcional. " +
                                        "Con su diseño elegante y rendimiento superior, este modelo combina " +
                                        "perfectamente estilo y funcionalidad.",
                                fontSize = 16.sp,
                                lineHeight = 24.sp
                            )

                            Spacer(modifier = Modifier.height(24.dp))

                            Button(
                                onClick = { /* Reservar */ },
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.primary
                                )
                            ) {
                                Text(
                                    text = "Reservar ahora",
                                    fontSize = 18.sp,
                                    modifier = Modifier.padding(vertical = 8.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun CarCard(
    carName: String,
    carType: String,
    imageUrl: String,
    passengers: Int,
    transmission: String,
    pricePerDay: String,
    onClick: () -> Unit = {}
) {
    Surface(
        shape = RoundedCornerShape(18.dp),
        shadowElevation = 6.dp,
        modifier = Modifier
            .padding(16.dp),
        color = Color.White,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Título y tipo de coche
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = carName,
                        fontSize = 20.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = carType,
                        fontSize = 14.sp,
                        fontFamily = poppinsFontFamily,
                        color = Color.Gray
                    )
                }

                LikeButton {

                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            // Cargar imagen con Coil

            Image(
                painter = rememberAsyncImagePainter(model = imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(8.dp))


            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.WbSunny,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "$passengers",
                    modifier = Modifier.padding(start = 4.dp, end = 16.dp),
                    fontFamily = poppinsFontFamily,
                    fontSize = 14.sp
                )

                Icon(
                    painter = painterResource(resource = Res.drawable.Gearbox),
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = transmission,
                    modifier = Modifier.padding(start = 4.dp),
                    fontFamily = poppinsFontFamily,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.weight(1f))

                // Precio por día
                Text(
                    text = pricePerDay,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFontFamily,
                    textAlign = TextAlign.End
                )
            }
        }


    }
}

@Preview
@Composable
fun CarList() {
    var expandedCardIndex by remember { mutableStateOf<Int?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
//        LazyColumn(
//            modifier = Modifier.fillMaxSize(),
//            contentPadding = PaddingValues(16.dp)
//        ) {
//            items(5) { index ->
                AnimatedCarCard(
                    carName = "Porsche 718 Cayman",
                    carType = "Coupe",
                    imageUrl = "https://pngimg.com/d/maserati_PNG28.png",
                    passengers = 2,
                    transmission = "Manual",
                    pricePerDay = "$400/d",
                    isExpanded = expandedCardIndex == 0,
                    onExpand = { expandedCardIndex = 0 },
                    onCollapse = { expandedCardIndex = null }
                )
                if (expandedCardIndex == null) {
                    Spacer(modifier = Modifier.height(16.dp))
                }
//            }
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CarList()
}

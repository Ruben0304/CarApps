package ruben.hernandez.rentalcar.views.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.filled.Air
import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetLayout(
    content: @Composable () -> Unit,
    sheetContent: @Composable () -> Unit
) {
    val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = sheetState)
    val scope = rememberCoroutineScope()

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val screenHeight = maxHeight

        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetContent = {
                Column {
                    Spacer(
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .width(40.dp)
                            .height(4.dp)
                            .background(Color.LightGray)
                            .align(Alignment.CenterHorizontally)
                    )
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(screenHeight - 24.dp)
                    ) {
                        sheetContent()
                    }
                }
            },
            sheetPeekHeight = 0.dp,
            sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
        ) {
            Box(Modifier.fillMaxSize()) {
                content()
                if (sheetState.isExpanded) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black.copy(alpha = 0.5f))
                    )
                }
            }
        }

        Button(
            onClick = {
                scope.launch {
                    if (sheetState.isCollapsed) sheetState.expand() else sheetState.collapse()
                }
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd)
        ) {
            Text("Toggle Bottom Sheet")
        }
    }
}

@Composable
fun CarDetailContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    "Porsche 718 Cayman S",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text("Coupe", color = Color.Gray)
            }
            Icon(
                Icons.Default.Favorite,
                contentDescription = "Favorite",
                tint = Color.Red
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = android.R.drawable.ic_menu_gallery), // Placeholder
            contentDescription = "Porsche 718 Cayman S",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Car Specs", fontWeight = FontWeight.Bold)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CarSpecItem("Max. Power", "320\nhp")
            CarSpecItem("0 - 60mph", "4.4\ns")
            CarSpecItem("Top Speed", "177\nmph")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Car Info", fontWeight = FontWeight.Bold)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CarInfoItem(Icons.Default.Person, "2 Passengers")
            CarInfoItem(Icons.Default.Air, "Air Conditioning")
            CarInfoItem(Icons.Default.DirectionsCar, "2 Doors")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
        ) {
            Text("Go to Book", color = Color.White)
        }
    }
}

@Composable
fun CarSpecItem(title: String, value: String) {
    Column {
        Text(title, color = Color.Gray, fontSize = 12.sp)
        Text(value, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun CarInfoItem(icon: ImageVector, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null, tint = Color.Gray)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text, color = Color.Gray, fontSize = 12.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun BottomSheetPreview() {
    MaterialTheme {
        BottomSheetLayout(
            content = {
                Box(Modifier.fillMaxSize()) {
                    Text("Contenido principal", modifier = Modifier.align(Alignment.Center))
                }
            },
            sheetContent = {
                CarDetailContent()
            }
        )
    }
}
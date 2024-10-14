package ruben.hernandez.rentalcar


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.painterResource


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.Gearbox
import carrental.composeapp.generated.resources.Home
import carrental.composeapp.generated.resources.Res
import ruben.hernandez.rentalcar.appclip.AppClip
import ruben.hernandez.rentalcar.appclip.CloseButton

import ruben.hernandez.rentalcar.basicdialogo.BasicDialogo
import ruben.hernandez.rentalcar.jjk.Jjk
import ruben.hernandez.rentalcar.messagebubble.MessageBubble
import ruben.hernandez.rentalcar.messagebubbleligth.MessageBubbleLigth


import ruben.hernandez.rentalcar.navigation.AppRoutes
import ruben.hernandez.rentalcar.settingsaccount.RightContent
import ruben.hernandez.rentalcar.settingsaccount.SettingsAccount

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            AppRoutes(navController = navController)
//            App(navController)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun AppAndroidPreview() {
//    val navController = rememberNavController()
//    AppRoutes(navController = navController)
//SettingsAccount(Modifier.padding(top = 200.dp, start = 10.dp), icono = painterResource(resource = Res.drawable.Gearbox), nombre = "Ruben")
//    MaterialTheme {
//        Surface(color = Color(0xFFF1F3F4)) {
//            Send()
//        }
//    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(253, 249, 249, 255),
                        Color(253, 233, 253, 255),
                        Color(248, 242, 252, 255)
                    )
                )
            )
    ) {
        Column {
            BasicDialogo(title = "Mmawebo", labelTextSecondaryButton = "aceptar", labelTextPrimmaryButton = "Cancelar")
//            Jjk(onImageCarouselSliderTapped = { println("sdd") })
        }
//        Row {
//            LazyColumn(modifier = Modifier.fillMaxWidth(.50f), horizontalAlignment = Alignment.Start) {
//                items(3){
////                    MessageBubble(text = "El taiger woods")
//                    MessageBubbleLigth(text = "Si miro pa abajo")
//                    Spacer(modifier = Modifier.height(15.dp))
//                }
//            }
//            LazyColumn(Modifier.padding(end = 19.dp),horizontalAlignment = Alignment.End
//            ) {
//                items(3){
//                    Spacer(modifier = Modifier.height(15.dp))
//                    MessageBubble(text = "El taiger woods")
//                    Spacer(modifier = Modifier.height(15.dp))
////                    MessageBubbleLigth(text = "Si miro pa abajo")
//                }
//            }
//        }
//
//        ElegantChatInput(
//            modifier = Modifier
//                .fillMaxWidth()
//                .align(Alignment.BottomCenter)
//
//        )

    }

}


@Composable
fun ElegantChatInput(modifier: Modifier) {
    var message by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .padding(horizontal = 12.dp, vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /* Handle camera/attachment */ },

                ) {
                Icon(
                    imageVector = Icons.Default.PhotoCamera,
                    contentDescription = "Attach",
                    tint = Color.Gray,
                    modifier = Modifier.size(28.dp)
                )
            }
            androidx.compose.material3.Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color.White)
                    .shadow(elevation = 34.dp, ambientColor = Color.Blue, spotColor = Color.Blue),
                elevation = CardDefaults.cardElevation(34.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            )
            {
                Row(verticalAlignment = Alignment.CenterVertically) {


                    TextField(
                        value = message,
                        onValueChange = { message = it },
                        modifier = Modifier
                            .weight(1f),
                        textStyle = TextStyle(fontSize = 12.sp),
                        placeholder = { Text("Message", color = Color.Gray) },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        singleLine = true
                    )

                    IconButton(
                        onClick = { /* Handle send message */ },
                        modifier = Modifier
                            .padding(end = 20.dp)
                            .width(36.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF4285F4))
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowUpward,
                            contentDescription = "Send",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}


package ruben.hernandez.rentalcar.views.components

import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Environment
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import coil.compose.rememberAsyncImagePainter
import ruben.hernandez.rentalcar.views.screens.ChatMessage
import java.io.File


@Composable
fun AnimatedMessageBubble(message: ChatMessage) {
    val animationDuration = 200 // Duración de la animación en milisegundos

    // Usamos LaunchedEffect para animar solo cuando el mensaje se agrega
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(message) {
        visible = true
    }

    // Animamos la visibilidad del mensaje cuando se agrega
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(animationSpec = tween(animationDuration)) +
                slideInVertically(
                    initialOffsetY = { it }, // Desplaza desde la parte inferior
                    animationSpec = tween(animationDuration)
                ) + scaleIn(
            initialScale = 0.8f,
            animationSpec = tween(animationDuration)
        ),
        exit = fadeOut(animationSpec = tween(animationDuration))
    ) {
        MessageBubble(message)
    }
}
@Composable
fun MessageBubble(message: ChatMessage) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (message.isReceived) Alignment.Start else Alignment.End
    ) {
        Surface(elevation = 3.dp, shape =  RoundedCornerShape(
            topStart = 18.dp,
            topEnd = 18.dp,
            bottomStart = if (message.isReceived) 0.dp else 18.dp,
            bottomEnd = if (message.isReceived) 18.dp else 0.dp
        ),color = Color.Transparent) {
            Box(
                modifier = Modifier
                    .widthIn(max = 280.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 18.dp,
                            topEnd = 18.dp,
                            bottomStart = if (message.isReceived) 0.dp else 18.dp,
                            bottomEnd = if (message.isReceived) 18.dp else 0.dp
                        )
                    )
                    .background(if (message.isReceived) Color(0xFFE5E5EA) else Color(0xFF007AFF))
                    .padding(12.dp)

            ) {
                if (message.imageUri != null) {
                    Image(
                        painter = rememberAsyncImagePainter(message.imageUri),
                        contentDescription = null,
                        modifier = Modifier.size(150.dp)
                    )
                } else {
                    Text(
                        text = message.content ?: "",
                        color = if (message.isReceived) Color.Black else Color.White,
                        style = TextStyle(fontSize = 16.sp),
                        modifier = Modifier.align(if (message.isReceived) Alignment.CenterStart else Alignment.CenterEnd)
                    )
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ElegantChatInput(
    modifier: Modifier,
    onSendMessage: (String) -> Unit,
    onSendImage: (Uri) -> Unit
) {
    var message by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var capturedImageUri by remember { mutableStateOf<Uri?>(null) }

    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success && capturedImageUri != null) {
            onSendImage(capturedImageUri!!)
        }
    }

    val galleryLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            onSendImage(it)
        }
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            capturedImageUri = createImageFile(context)
            capturedImageUri?.let { cameraLauncher.launch(it) }
        } else {
            Toast.makeText(context, "Permiso para la cámara denegado", Toast.LENGTH_SHORT).show()
        }
    }

    if (showDialog) {
        CustomCameraGalleryDialog(
            onCameraClick = {
                if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    capturedImageUri = createImageFile(context)
                    cameraLauncher.launch(capturedImageUri!!)
                } else {
                    permissionLauncher.launch(android.Manifest.permission.CAMERA)
                }
            },
            onGalleryClick = {
                galleryLauncher.launch("image/*")
            },
            onDismiss = { showDialog = false }
        )
    }

    Box(
        modifier = modifier.padding(horizontal = 12.dp, vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { showDialog = true },
            ) {
                Icon(
                    imageVector = Icons.Default.Camera,
                    contentDescription = "Attach",
                    tint = Color.Gray,
                    modifier = Modifier.size(28.dp)
                )
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color.White),
                border = BorderStroke(1.dp,Color.LightGray),
                shape = RoundedCornerShape(24.dp),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextField(
                        value = message,
                        onValueChange = { message = it },
                        modifier = Modifier.weight(1f),
                        textStyle = TextStyle(fontSize = 14.sp),
                        placeholder = { Text("Message", color = Color.Gray) },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            cursorColor =  Color(0xFF4285F4),
                        ),
                        singleLine = true
                    )

                    Surface(
                        onClick = {
                            if (message.isNotBlank()) {
                                onSendMessage(message)
                                message = ""
                            }
                        },
                        shape = CircleShape,
                        elevation = 2.dp,
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .size(32.dp),
                        color = Color(0xFF4285F4)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Default.ArrowUpward,
                                contentDescription = "Send",
                                tint = Color.White,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

// Función para crear un archivo temporal donde guardar la imagen capturada por la cámara
fun createImageFile(context: Context): Uri {
    // Crear un archivo temporal único para la imagen
    val timeStamp = System.currentTimeMillis().toString()
    val fileName = "JPEG_${timeStamp}_"
    val storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    val imageFile = File.createTempFile(fileName, ".jpg", storageDir)

    // Devolver la Uri del archivo usando FileProvider
    return FileProvider.getUriForFile(
        context,
        "${context.packageName}.provider",
        imageFile
    )
}
@Composable
fun CustomCameraGalleryDialog(
    onCameraClick: () -> Unit,
    onGalleryClick: () -> Unit,
    onDismiss: () -> Unit
) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible = true
    }

    if (visible) {
        AnimatedVisibility(
            visible = true,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically()
        ) {
            Dialog(onDismissRequest = {
                visible = false
                onDismiss()
            }) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    elevation = 8.dp
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Seleccione una opción",
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            IconButton(
                                onClick = {
                                    visible = false
                                    onCameraClick()
                                },
                                modifier = Modifier.size(72.dp)
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Icon(
                                        Icons.Filled.CameraAlt,
                                        contentDescription = "Cámara",
                                        modifier = Modifier.size(36.dp),
                                        tint = Color(121, 168, 123, 255)
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text("Cámara", style = MaterialTheme.typography.caption)
                                }
                            }
                            IconButton(
                                onClick = {
                                    visible = false
                                    onGalleryClick()
                                },
                                modifier = Modifier.size(72.dp)
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Icon(
                                        Icons.Filled.Image,
                                        contentDescription = "Galería",
                                        modifier = Modifier.size(36.dp),
                                        tint = Color(104, 143, 243, 255)
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text("Galería", style = MaterialTheme.typography.caption)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

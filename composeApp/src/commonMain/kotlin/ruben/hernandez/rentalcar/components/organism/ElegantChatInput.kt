//package ruben.hernandez.rentalcar.components.organism
//
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.Icon
//import androidx.compose.material.IconButton
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
//import androidx.compose.material.TextField
//import androidx.compose.material.TextFieldDefaults
//import androidx.compose.material.icons.Icons
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import ruben.hernandez.rentalcar.AppColors
//
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun ElegantChatInput(
//    modifier: Modifier,
//    onSendMessage: (String) -> Unit,
//    onSendImage: (Uri) -> Unit
//) {
//    var message by remember { mutableStateOf("") }
//    var showDialog by remember { mutableStateOf(false) }
//    val context = LocalContext.current
//    var capturedImageUri by remember { mutableStateOf<Uri?>(null) }
//
//    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
//        if (success && capturedImageUri != null) {
//            onSendImage(capturedImageUri!!)
//        }
//    }
//
//    val galleryLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
//        uri?.let {
//            onSendImage(it)
//        }
//    }
//
//    val permissionLauncher = rememberLauncherForActivityResult(
//        ActivityResultContracts.RequestPermission()
//    ) { isGranted ->
//        if (isGranted) {
//            capturedImageUri = createImageFile(context)
//            capturedImageUri?.let { cameraLauncher.launch(it) }
//        } else {
//            Toast.makeText(context, "Permiso para la cámara denegado", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    if (showDialog) {
//        CustomCameraGalleryDialog(
//            onCameraClick = {
//                if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
//                    capturedImageUri = createImageFile(context)
//                    cameraLauncher.launch(capturedImageUri!!)
//                } else {
//                    permissionLauncher.launch(Manifest.permission.CAMERA)
//                }
//            },
//            onGalleryClick = {
//                galleryLauncher.launch("image/*")
//            },
//            onDismiss = { showDialog = false }
//        )
//    }
//
//    Box(
//        modifier = modifier.padding(horizontal = 12.dp, vertical = 16.dp)
//    ) {
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            IconButton(
//                onClick = { showDialog = true },
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Camera,
//                    contentDescription = "Attach",
//                    tint = Color.Gray,
//                    modifier = Modifier.size(28.dp)
//                )
//            }
//            Surface(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clip(RoundedCornerShape(24.dp))
//                    .background(AppColors.cardsBackground),
//                border = BorderStroke(1.dp, Color.LightGray),
//                shape = RoundedCornerShape(24.dp),
//            ) {
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    TextField(
//                        value = message,
//                        onValueChange = { message = it },
//                        modifier = Modifier.weight(1f),
//                        textStyle = TextStyle(fontSize = 14.sp),
//                        placeholder = { Text("Message", color = Color.Gray) },
//                        colors = TextFieldDefaults.textFieldColors(
//                            backgroundColor = Color.Transparent,
//                            focusedIndicatorColor = Color.Transparent,
//                            unfocusedIndicatorColor = Color.Transparent,
//                            cursorColor =  Color(0xFF4285F4),
//                        ),
//                        singleLine = true
//                    )
//
//                    Surface(
//                        onClick = {
//                            if (message.isNotBlank()) {
//                                onSendMessage(message)
//                                message = ""
//                            }
//                        },
//                        shape = CircleShape,
//                        elevation = 2.dp,
//                        modifier = Modifier
//                            .padding(end = 12.dp)
//                            .size(32.dp),
//                        color = Color(0xFF4285F4)
//                    ) {
//                        Box(contentAlignment = Alignment.Center) {
//                            Icon(
//                                imageVector = Icons.Default.ArrowUpward,
//                                contentDescription = "Send",
//                                tint = AppColors.cardsBackground,
//                                modifier = Modifier.size(18.dp)
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
package ruben.hernandez.rentalcar.components.organism

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

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
//                                    Icon(
//                                        Icons.Filled.CameraAlt,
//                                        contentDescription = "Cámara",
//                                        modifier = Modifier.size(36.dp),
//                                        tint = Color(121, 168, 123, 255)
//                                    )
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
//                                    Icon(
//                                        Icons.Filled.Image,
//                                        contentDescription = "Galería",
//                                        modifier = Modifier.size(36.dp),
//                                        tint = Color(104, 143, 243, 255)
//                                    )
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
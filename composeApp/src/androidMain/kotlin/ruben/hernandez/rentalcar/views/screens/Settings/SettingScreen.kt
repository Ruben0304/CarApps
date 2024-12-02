//package ruben.hernandez.rentalcar.views.screens.Settings
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.ui.zIndex
//import carrental.composeapp.generated.resources.Ajustes
//import carrental.composeapp.generated.resources.Res
//import org.jetbrains.compose.ui.tooling.preview.Preview
//import ruben.hernandez.rentalcar.AppColors
//import ruben.hernandez.rentalcar.views.poppinsFontFamily
//
//@androidx.compose.ui.tooling.preview.Preview
//@Composable
//fun SettingsScreenPreview() {
//    MaterialTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            SettingsScreen()
//        }
//    }
//}
//
//@Composable
//fun SettingsScreen() {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(
//                brush = Brush.verticalGradient(
//                    colors = AppColors.backgroundGradient
//                )
//            )
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//                .zIndex(1f) // Asegura que la imagen esté por encima del contenido
//        ) {
//            Image(
//                painter = org.jetbrains.compose.resources.painterResource(resource = Res.drawable.Ajustes),
//                contentDescription = "Settings image",
//                modifier = Modifier.fillMaxSize(),
//                contentScale = ContentScale.Crop
//            )
//            // Overlay con degradado negro
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(
//                        brush = Brush.verticalGradient(
//                            colors = listOf(
//                                Color.Black.copy(alpha = 0.6f),
//                                Color.Black.copy(alpha = 0.3f)
//                            )
//                        )
//                    )
//            )
//        }
//
//        LazyColumn(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(top = 200.dp)
//        ) {
//            item {
//                SettingsSection(title = "AJUSTES Y PREFERENCIAS") {
//                    SettingsItem(
//                        icon = Icons.Default.Language,
//                        title = "Idioma",
//                        hasToggle = false,
//                        hasArrow = true
//                    )
//                    SettingsItem(
//                        icon = Icons.Default.DarkMode,
//                        title = "Modo oscuro",
//                        hasToggle = true,
//                        hasArrow = false
//                    )
//                    SettingsItem(
//                        icon = Icons.Default.Notifications,
//                        title = "Notificaciones",
//                        hasToggle = true,
//                        hasArrow = false
//                    )
//                    SettingsItem(
//                        icon = Icons.Default.VolumeUp,
//                        title = "Sonidos",
//                        hasToggle = true,
//                        hasArrow = false
//                    )
//                }
//            }
//
//            item {
//                SettingsSection(title = "SOPORTE") {
//                    SettingsItem(
//                        icon = Icons.Default.Info,
//                        title = "Acerca de",
//                        hasToggle = false,
//                        hasArrow = true
//                    )
//                    SettingsItem(
//                        icon = Icons.Default.Help,
//                        title = "Centro de ayuda",
//                        hasToggle = false,
//                        hasArrow = true
//                    )
//                    SettingsItem(
//                        icon = Icons.Default.Policy,
//                        title = "Política de privacidad",
//                        hasToggle = false,
//                        hasArrow = true
//                    )
//                    SettingsItem(
//                        icon = Icons.Default.Description,
//                        title = "Términos de servicio",
//                        hasToggle = false,
//                        hasArrow = true
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//private fun SettingsSection(
//    title: String,
//    content: @Composable () -> Unit
//) {
//    Column(
//        modifier = Modifier.padding(vertical = 8.dp)
//    ) {
//        Text(
//            text = title,
//            style = MaterialTheme.typography.labelLarge.copy(
//                fontFamily = poppinsFontFamily,
//                fontWeight = FontWeight.Bold,
//                color = AppColors.text
//            ),
//            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
//        )
//        content()
//    }
//}
//
//@Composable
//private fun SettingsItem(
//    icon: ImageVector,
//    title: String,
//    hasToggle: Boolean = false,
//    hasArrow: Boolean = false,
//    onClick: () -> Unit = {}
//) {
//    Surface(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 16.dp, vertical = 4.dp),
//        shape = RoundedCornerShape(12.dp),
//        color = AppColors.navColor
//    ) {
//        Row(
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth()
//                .height(48.dp), // Altura fija para todos los items
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Row(
//                horizontalArrangement = Arrangement.Start,
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.weight(1f)
//            ) {
//                Icon(
//                    imageVector = icon,
//                    contentDescription = null,
//                    tint = AppColors.principal,
//                    modifier = Modifier.size(24.dp)
//                )
//                Spacer(modifier = Modifier.width(16.dp))
//                Text(
//                    text = title,
//                    color = AppColors.text,
//                    style = MaterialTheme.typography.bodyLarge.copy(
//                        fontFamily = poppinsFontFamily
//                    )
//                )
//            }
//
//            Box(
//                modifier = Modifier.width(60.dp),
//                contentAlignment = Alignment.Center
//            ) {
//                if (hasToggle) {
//                    var isChecked by remember { mutableStateOf(false) }
//                    Switch(
//                        checked = isChecked,
//                        onCheckedChange = { isChecked = it },
//                        colors = SwitchDefaults.colors(
//                            checkedThumbColor = AppColors.principal,
//                            checkedTrackColor = AppColors.principal.copy(alpha = 0.5f),
//                            uncheckedThumbColor = AppColors.text,
//                            uncheckedTrackColor = Color.White
//                        )
//                    )
//                }
//
//                if (hasArrow) {
//                    Icon(
//                        imageVector = Icons.Default.ChevronRight,
//                        contentDescription = null,
//                        tint = AppColors.text
//                    )
//                }
//            }
//        }
//    }
//}
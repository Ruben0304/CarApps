package ruben.hernandez.rentalcar.views.fragments

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import carrental.composeapp.generated.resources.Res
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.views.poppinsFontFamily
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Dialog
import carrental.composeapp.generated.resources.Homedark
import carrental.composeapp.generated.resources.Homelight
import org.koin.androidx.compose.koinViewModel
import ruben.hernandez.rentalcar.navigation.Destination
import ruben.hernandez.rentalcar.navigation.DestinationP
import ruben.hernandez.rentalcar.viewModels.SettingsEvent
import ruben.hernandez.rentalcar.viewModels.SettingsViewModel


@Composable
fun SettingsFragment(
    paddingValues: PaddingValues,
    hazeState: HazeState,
    navigateToOtherItem: (String) -> Unit,
    viewModel: SettingsViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.navigationEvent.collect { event ->
            when (event) {
                is SettingsEvent.NavigateToAccount -> {
                    navigateToOtherItem(DestinationP.Account.route)
                }
                else -> {}
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = AppColors.backgroundGradient
                )
            )
    ) {
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .haze(hazeState)
        ) {
            item {
                ThemeSelector(
                    isDarkMode = uiState.isDarkMode,
                    onThemeChange = viewModel::updateTheme
                )
            }

            item {
                SettingsSection(title = "AJUSTES Y PREFERENCIAS") {
                    SettingsItem(
                        icon = Icons.Default.AccountCircle,
                        title = "Cuenta",
                        hasArrow = true,
                        onClick = viewModel::loadAccount
                    )

                    SettingsItem(
                        icon = Icons.Default.Notifications,
                        title = "Notificaciones",
                        hasToggle = true,
                        isChecked = uiState.notificationsEnabled,
                        onToggleChange = viewModel::updateNotifications
                    )
                    SettingsItem(
                        icon = Icons.Default.VolumeUp,
                        title = "Sonidos",
                        hasToggle = true,
                        isChecked = uiState.soundsEnabled,
                        onToggleChange = viewModel::updateSounds
                    )
                    SettingsItem(
                        icon = Icons.Default.Language,
                        title = "Idioma",
                        hasToggle = false,
                        hasArrow = true
                    )
                    ExpandableSettingsItem(
                        icon = Icons.Default.Favorite,
                        title = "Servicio preferido",
                        selectedOption = uiState.preferredService,
                        options = listOf("Consultas", "Comprar piezas", "Renta"),
                        onOptionSelected = viewModel::updatePreferredService
                    )
                }
            }

            item {
                SettingsSection(title = "SOPORTE") {
                    SettingsItem(
                        icon = Icons.Default.Info,
                        title = "Acerca de",
                        hasToggle = false,
                        hasArrow = true
                    )
                    SettingsItem(
                        icon = Icons.Default.Help,
                        title = "Centro de ayuda",
                        hasToggle = false,
                        hasArrow = true
                    )
                    SettingsItem(
                        icon = Icons.Default.Policy,
                        title = "Política de privacidad",
                        hasToggle = false,
                        hasArrow = true
                    )
                    SettingsItem(
                        icon = Icons.Default.Description,
                        title = "Términos de servicio",
                        hasToggle = false,
                        hasArrow = true
                    )
                }
            }
        }
    }
}

@Composable
fun ThemeSelector(
    isDarkMode: Boolean,
    onThemeChange: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ThemeOption(
                image = org.jetbrains.compose.resources.painterResource(Res.drawable.Homelight),
                label = "Claro",
                isSelected = !isDarkMode
            ) {
                onThemeChange(false)
            }

            Spacer(modifier = Modifier.width(24.dp))

            ThemeOption(
                image = org.jetbrains.compose.resources.painterResource(Res.drawable.Homedark),
                label = "Oscuro",
                isSelected = isDarkMode
            ) {
                onThemeChange(true)
            }
        }
    }
}

@Composable
fun ThemeOption(
    image: Painter,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val animatedScale by animateFloatAsState(
        targetValue = if (isSelected) 1.02f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .scale(animatedScale)
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .size(width = 160.dp, height = 260.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            Image(
                painter = image,
                contentDescription = label,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        RadioButton(
            selected = isSelected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = AppColors.principal,
                unselectedColor = Color.Gray
            )
        )

        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = if (isSelected) AppColors.principal else AppColors.text,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun SettingsSection(
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge.copy(
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
                color = AppColors.text
            ),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        content()
    }
}

@Composable
private fun SettingsItem(
    icon: ImageVector,
    title: String,
    hasToggle: Boolean = false,
    hasArrow: Boolean = false,
    isChecked: Boolean = false,
    onToggleChange: (Boolean) -> Unit = {},
    onClick: () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable(enabled = !hasToggle) { onClick() },
        shape = MaterialTheme.shapes.medium,
        color = AppColors.cardsBackground
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(48.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = title,
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontFamily = poppinsFontFamily
                    )
                )
            }

            if (hasToggle) {
                Switch(
                    checked = isChecked,
                    onCheckedChange = onToggleChange,
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = AppColors.principal,
                        checkedTrackColor = AppColors.principal.copy(alpha = 0.5f),
                        uncheckedThumbColor = AppColors.text,
                        uncheckedTrackColor = AppColors.cardsBackground.copy(alpha = 0.5f)
                    )
                )
            }

            if (hasArrow) {
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = null,
                    tint = AppColors.principal
                )
            }
        }
    }
}

@Composable
private fun ExpandableSettingsItem(
    icon: ImageVector,
    title: String,
    selectedOption: String,
    options: List<String>,
    onOptionSelected: (String) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        shape = MaterialTheme.shapes.medium,
        color = AppColors.cardsBackground
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(48.dp)
                .clickable { showDialog = true },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = title,
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontFamily = poppinsFontFamily
                    )
                )
            }

            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = selectedOption,
                    color = AppColors.principal,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontFamily = poppinsFontFamily
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = AppColors.principal
                )
            }
        }
    }

    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            Surface(
                shape = MaterialTheme.shapes.medium,
                color = AppColors.cardsBackground
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Selecciona tu servicio preferido",
                        style = MaterialTheme.typography.titleMedium,
                        color = AppColors.text,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    options.forEach { option ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onOptionSelected(option)
                                    showDialog = false
                                }
                                .padding(vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            if (option == selectedOption) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = null,
                                    tint = AppColors.principal,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                            } else {
                                Spacer(modifier = Modifier.width(40.dp))
                            }
                            Text(
                                text = option,
                                color = if (option == selectedOption) AppColors.principal else AppColors.text,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                }
            }
        }
    }
}


package ruben.hernandez.rentalcar.views.fragments

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carrental.composeapp.generated.resources.Res
import carrental.composeapp.generated.resources.profile
import coil.compose.rememberAsyncImagePainter
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeChild
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials
import org.jetbrains.compose.resources.painterResource
import org.koin.androidx.compose.koinViewModel
import ruben.hernandez.rentalcar.navigation.Destination
import ruben.hernandez.rentalcar.navigation.DestinationP
import ruben.hernandez.rentalcar.viewModels.AccountEvent
import ruben.hernandez.rentalcar.viewModels.AccountViewModel
import ruben.hernandez.rentalcar.views.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class, ExperimentalHazeMaterialsApi::class)
@Composable
fun AccountFragment(
    paddingValues: PaddingValues,
    hazeState: HazeState,
    navigateToOtherItem: (String) -> Unit,
    viewModel: AccountViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    // Recolectar eventos
    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is AccountEvent.NavigateToSettings -> {
                    navigateToOtherItem(Destination.Settings.route)
                }
                is AccountEvent.ShowError -> {
                    // Aquí puedes mostrar un snackbar o dialog con el error
                }
                is AccountEvent.PhotoUpdated -> {
                    // Puedes mostrar una confirmación
                }

                else -> {}
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1C1C1E))
    ) {
        val scrollState = rememberScrollState()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent,
                        titleContentColor = Color.White
                    ),
                    modifier = Modifier
                        .statusBarsPadding()
                        .hazeChild(
                            state = hazeState,
                            style = HazeMaterials.thin(Color(0xFF2C2C2E))
                        ),
                    title = {
                        Text(
                            text = DestinationP.Account.route,
                            fontSize = 18.sp,
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    },
                    actions = {
                        TextButton(onClick = { viewModel.navigateToSettings() }) {
                            Text(
                                text = "Listo",
                                color = Color(0xFF007AFF),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
                    .verticalScroll(scrollState)
            ) {
                // Profile Photo Section
                val userProfile = uiState.userProfile
                if (userProfile != null) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = if (userProfile.photoUrl.isNotEmpty()) {
                                rememberAsyncImagePainter(userProfile.photoUrl)
                            } else {
                                painterResource(Res.drawable.profile)
                            },
                            contentDescription = "Profile Photo",
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = "${userProfile.firstName} ${userProfile.lastName}",
                            style = MaterialTheme.typography.titleLarge.copy(
                                color = Color.White,
                                fontWeight = FontWeight.Medium
                            ),
                            modifier = Modifier.padding(top = 8.dp)
                        )
                        TextButton(
                            onClick = {
                                // Implementar selección de foto
                            },
                            colors = ButtonDefaults.textButtonColors(
                                contentColor = Color(0xFF007AFF)
                            )
                        ) {
                            Text("Editar Foto")
                        }
                    }

                    // Account Settings Section
                    AccountSection(
                        items = listOf(
                            AccountItem(
                                "Nombre de usuario",
                                null,
                                Icons.Default.Person
                            ),
                            AccountItem(
                                "Contraseña",
                                null,
                                Icons.Default.Lock
                            )
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Characteristics Section
                    Text(
                        text = "Características",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    AccountSection(
                        items = listOf(
                            AccountItem(
                                "Nombre",
                                userProfile.firstName,
                                Icons.Default.Badge
                            ),
                            AccountItem(
                                "Apellidos",
                                userProfile.lastName,
                                Icons.Default.Person
                            ),
                            AccountItem(
                                "Ubicacion",
                                userProfile.location,
                                Icons.Default.LocationOn
                            )
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Car Section
                    Text(
                        text = "Mi auto",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    AccountSection(
                        items = listOf(
                            AccountItem(
                                "Marca",
                                userProfile.carInfo.brand,
                                Icons.Default.DirectionsCar
                            ),
                            AccountItem(
                                "Modelo",
                                userProfile.carInfo.model,
                                Icons.Default.Settings
                            ),
                            AccountItem(
                                "Año",
                                userProfile.carInfo.year,
                                Icons.Default.DateRange
                            )
                        )
                    )
                }

                // Loading state
                if (uiState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .wrapContentSize(Alignment.Center)
                    )
                }

                // Error state
                uiState.error?.let { error ->
                    Text(
                        text = error,
                        color = Color.Red,
                        modifier = Modifier.padding(16.dp)
                    )
                }

                // Footer con icono de seguridad
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Security,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier
                            .size(16.dp)
                            .padding(end = 8.dp)
                    )
                    Text(
                        text = "Tus datos se encriptan en tu dispositivo y son seguros",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Color.Gray,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }
        }
    }
}

@Composable
private fun AccountSection(items: List<AccountItem>) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(0xFF2C2C2E),
        shape = MaterialTheme.shapes.medium
    ) {
        Column {
            items.forEachIndexed { index, item ->
                AccountItemRow(
                    item = item,
                    showDivider = index < items.size - 1
                )
            }
        }
    }
}

@Composable
private fun AccountItemRow(
    item: AccountItem,
    showDivider: Boolean
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* TODO: Handle click */ }
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 12.dp)
                )
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.White
                    )
                )
            }
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (item.value != null) {
                    Text(
                        text = item.value,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.Gray
                        ),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        if (showDivider) {
            Divider(
                color = Color(0xFF3C3C3E),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

private data class AccountItem(
    val title: String,
    val value: String?,
    val icon: ImageVector
)


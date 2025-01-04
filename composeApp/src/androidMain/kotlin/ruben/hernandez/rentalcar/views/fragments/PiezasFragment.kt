package ruben.hernandez.rentalcar.views.fragments

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import org.koin.androidx.compose.koinViewModel
import ruben.hernandez.rentalcar.AppColors
import ruben.hernandez.rentalcar.viewModels.Parts.PiezasViewModel
import ruben.hernandez.rentalcar.viewModels.Parts.PartsUiState

@Composable
fun PiezasFragment(
    paddingValues: PaddingValues,
    hazeState: HazeState,
    navigateToOtherItem: (String) -> Unit
) {
    val viewModel: PiezasViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .haze(hazeState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (val state = uiState) {
            is PartsUiState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.padding(16.dp))
            }
            is PartsUiState.Success -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(state.parts) { part ->
                        Text(
                            text = "ID: ${part.id}, Tipo: ${part.tipo}, Modelo: ${part.modelo}",
                            color = AppColors.principal,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }
            is PartsUiState.Error -> {
                Text(
                    text = "Error: ${state.message}",
                    color = AppColors.principal,
                    modifier = Modifier.padding(16.dp)
                )
                Button(onClick = { viewModel.loadParts() }) {
                    Text("Retry")
                }
            }
        }
    }
}
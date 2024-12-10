package ruben.hernandez.rentalcar.viewModels.Parts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ruben.hernandez.rentalcar.models.Parts
import ruben.hernandez.rentalcar.repositories.PiezasRepository

sealed class PartsUiState {
    object Loading : PartsUiState()
    data class Success(val parts: List<Parts>) : PartsUiState()
    data class Error(val message: String) : PartsUiState()
}

class PiezasViewModel(
    private val repository: PiezasRepository
) : ViewModel(), KoinComponent {
    private val _uiState = MutableStateFlow<PartsUiState>(PartsUiState.Loading)
    val uiState: StateFlow<PartsUiState> = _uiState.asStateFlow()

    init {
        loadParts()
    }

    fun loadParts() {
        viewModelScope.launch {
            _uiState.value = PartsUiState.Loading
            try {
                val parts = repository.getAllParts()
                _uiState.value = PartsUiState.Success(parts)
            } catch (e: Exception) {
                _uiState.value = PartsUiState.Error(e.message ?: "Error desconocido")
            }
        }
    }

    fun getPartById(id: String) = repository.getPartById(id)

    fun addPart(part: ruben.hernandez.rentalcar.models.Parts): Boolean {
        return repository.addPart(part)
    }
}
















































//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.apollographql.apollo.exception.ApolloException
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.launch
//import ruben.hernandez.rentalcar.apollo.ApolloGraphQL
//import ruben.hernandez.rentalcar.models.Parts
//
//class PartsCenterViewModel : ViewModel() {
//
//    private val _uiState = MutableStateFlow<ListUiState>(ListUiState.Loading)
//    val uiState: StateFlow<ListUiState> = _uiState.asStateFlow()
//
//    init {
//        loadItems()
//    }
//
//    fun loadItems() {
//        viewModelScope.launch {
//            _uiState.value = ListUiState.Loading
//            try {
//                val response = ApolloGraphQL.apolloClient.query(PartsListQuery()).execute()
//                response.data?.let { data ->
//                    val items = data.piezas.map { item ->
//                        Parts(
//                            id = item.Id,
//                            tipo = item.tipo,
//                            modelo = item.modelo,
//                            precio = item.precio,
//                            uso = item.uso,
//                            cantidad = item.cantidad
//                        )
//                    }
//                    _uiState.value = ListUiState.Success(items)
//                } ?: run {
//                    _uiState.value = ListUiState.Error("No se encontraron piezas")
//                }
//            } catch (e: ApolloException) {
//                _uiState.value = ListUiState.Error(e.message ?: "Error desconocido")
//            }
//        }
//    }
//
//    fun refresh() {
//        loadItems()
//    }
//}
//
//// Estado UI para representar los diferentes estados de la pantalla
//sealed class ListUiState {
//    data object Loading : ListUiState()
//    data class Success(val items: List<Parts>) : ListUiState()
//    data class Error(val message: String) : ListUiState()
//}
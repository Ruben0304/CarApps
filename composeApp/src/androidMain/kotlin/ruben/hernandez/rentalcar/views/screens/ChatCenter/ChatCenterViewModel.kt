package ruben.hernandez.rentalcar.views.screens.ChatCenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.exception.ApolloException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ruben.hernandez.rentalcar.ApolloGraphQL
import ruben.hernandez.rentalcar.ChatListQuery


class ChatCenterViewModel(
) : ViewModel() {

    private val _uiState = MutableStateFlow<ListUiState>(ListUiState.Loading)
    val uiState: StateFlow<ListUiState> = _uiState.asStateFlow()

    init {
        loadItems()
    }

    fun loadItems() {
        viewModelScope.launch {
            _uiState.value = ListUiState.Loading
            try {
//                val response = ApolloGraphQL.apolloClient.query(ChatListQuery()).execute()
//                response.data?.let { data ->
//                    // Mapear la respuesta GraphQL a tu modelo de datos
//                    val items = data.items.map { item ->
//                        Item(
//                            id = item.id,
//                            title = item.title
//                        )
//                    }
//                    _uiState.value = ListUiState.Success(items)
//                } ?: run {
//                    _uiState.value = ListUiState.Error("No se encontraron datos")
//                }
            } catch (e: ApolloException) {
                _uiState.value = ListUiState.Error(e.message ?: "Error desconocido")
            }
        }
    }

    // Función para refrescar los datos
    fun refresh() {
        loadItems()
    }
}


// Estado UI que representa los diferentes estados de la pantalla
sealed class ListUiState {
    data object Loading : ListUiState()
    data class Success(val items: List<Item>) : ListUiState()
    data class Error(val message: String) : ListUiState()
}

// Modelo de datos
data class Item(
    val id: String,
    val title: String,
    // Agrega aquí los campos necesarios
)

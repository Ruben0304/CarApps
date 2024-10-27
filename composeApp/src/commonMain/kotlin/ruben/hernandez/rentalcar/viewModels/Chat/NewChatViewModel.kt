package ruben.hernandez.rentalcar.viewModels.Chat

import androidx.lifecycle.ViewModel
import ruben.hernandez.rentalcar.models.Mecanico

class NewChatViewModel : ViewModel() {

    var listProvincias = emptyList<String>()

    var listMunicipios = emptyList<String>()

    var listMec = emptyList<Mecanico>()

    init {
        cargarDatos()
    }

    fun cargarDatos() {
        listMunicipios = listOf(
            "Todos",
            "Playa",
            "Marianao",
            "La Lisa",
            "El Vedado",
            "La Habana Vieja",
            "Habana Del Este"
        )
        listProvincias = listOf(
            "La Habana",
            "Santiago de Cuba",
            "Las Tunas",
            "Pinar del Rio",
            "Villa Clara",
            "Guantanamo",
            "Granma"
        )

        val url = "https://pic.616pic.com/ys_img/01/09/35/2OKPEnNH98.jpg"

        listMec = listOf(
            Mecanico(
                "Eduardo",
                "Fonseca",
                url
            ),
            Mecanico(
                "Ruben",
                "Hernanez",
                url
            ),
            Mecanico(
                "Fabian",
                "Fernandez",
                url
            ),
            Mecanico(
                "Eduardo",
                "Fonseca",
                url
            ),
            Mecanico(
                "Ruben",
                "Hernanez",
                url
            ),
            Mecanico(
                "Fabian",
                "Fernandez",
                url
            )
        )
    }
}
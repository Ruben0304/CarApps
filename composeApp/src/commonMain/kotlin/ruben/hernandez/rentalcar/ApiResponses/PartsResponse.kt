package ruben.hernandez.rentalcar.ApiResponses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ruben.hernandez.rentalcar.models.Parts

@Serializable
data class PartsResponse(
    val status: String,
    val data: List<Pieza>,
    val message: String?
)

@Serializable
data class Pieza(
    @SerialName("_id") // Importante: mapea el campo _id de MongoDB
    val id: String,
    val nombre: String,
    val descripcion: String,
    val foto: String,
    val modelos_compatibles: List<String>,
    val estado: String,
    val precio: Double,
    val informacion_adicional: String,
    val id_vendedor: Int
)

fun Pieza.toParts(): Parts {
    return Parts(
        id = id,
        tipo = estado, // Assuming 'estado' corresponds to 'tipo'
        modelo = modelos_compatibles.firstOrNull() ?: "", // Using the first compatible model as 'modelo'
        precio = precio.toInt(),
        uso = informacion_adicional,
        cantidad = 1 // Default value, adjust as needed
    )
}

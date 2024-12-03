package ruben.hernandez.rentalcar.models

data class Parts(
    val id: String,
    val tipo: String?,
    val modelo: String?,
    val precio: Int?,
    val uso: String?,
    val cantidad: Int?
)
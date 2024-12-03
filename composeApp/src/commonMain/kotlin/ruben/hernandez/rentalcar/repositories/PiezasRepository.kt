package ruben.hernandez.rentalcar.repositories

import ruben.hernandez.rentalcar.ApiResponses.Pieza
import ruben.hernandez.rentalcar.models.Parts

interface PiezasRepository {
    suspend fun getAllParts(): List<Parts>
    fun getPartById(id: String): Parts?
    fun addPart(part: Parts): Boolean
}
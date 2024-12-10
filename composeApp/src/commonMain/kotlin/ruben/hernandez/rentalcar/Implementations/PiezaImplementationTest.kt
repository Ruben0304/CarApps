package ruben.hernandez.rentalcar.Implementations

import io.ktor.client.HttpClient
import ruben.hernandez.rentalcar.models.Parts
import ruben.hernandez.rentalcar.repositories.PiezasRepository

class PiezaImplementationTest(private val httpClient: HttpClient) : PiezasRepository {

    // Lista de datos iniciales
    private val partsList = mutableListOf(
        Parts("1", "Motor", "V8", 5000, "Nuevo", 10),
        Parts("2", "Transmisión", "Manual", 1200, "Usado", 5),
        Parts("3", "Frenos", "ABS", 300, "Nuevo", 20)
    )

    override suspend fun getAllParts(): List<Parts> = partsList

    override fun getPartById(id: String): Parts? = partsList.find { it.id == id }

    override fun addPart(part: Parts): Boolean {
        return if (part.id != null && partsList.none { it.id == part.id }) {
            partsList.add(part)
            true
        } else {
            false
        }
    }
}
package ruben.hernandez.rentalcar.Implementations

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import ruben.hernandez.rentalcar.ApiResponses.PartsResponse
import ruben.hernandez.rentalcar.ApiResponses.Pieza
import ruben.hernandez.rentalcar.ApiResponses.toParts
import ruben.hernandez.rentalcar.models.Parts
import ruben.hernandez.rentalcar.repositories.PiezasRepository
import ruben.hernandez.rentalcar.url.BASE_URL


class PiezaImplementation(private val httpClient: HttpClient) : PiezasRepository {
    override suspend fun getAllParts(): List<Parts> {
        try {
            val response: PartsResponse = httpClient.get(BASE_URL + "piezas") {
                contentType(ContentType.Application.Json)
            }.body()

            if (response.status == "SUCCESS") {
                return response.data.map { it.toParts() }
            } else {
                return emptyList()
            }
        } catch (e: Exception) {
            println("Error fetching parts: ${e.message}")
            return emptyList()
        }
    }
    override fun getPartById(id: String): Parts? {
        TODO("Not yet implemented")
    }

    override fun addPart(part: Parts): Boolean {
        TODO("Not yet implemented")
    }

}
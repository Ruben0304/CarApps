package ruben.hernandez.rentalcar.views.components

import java.util.List

import com.cohere.api.types.*
import kotlinx.serialization.Serializable
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.gson.gson
import kotlinx.coroutines.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.put


object CohereAI {

    suspend fun generateLlmPrompt( mensaje: String): String {
        val query = """Eres un mecanico de autos, reponde lo siguiente , no excedas de 30 caracteres en la respuesta: $mensaje"""

        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                Json { ignoreUnknownKeys = true }// Configura Json para ignorar claves desconocidas
            }
        }

        val payload = buildJsonObject {
            put("model", "llama3-70b-8192")
            put("messages", buildJsonArray {
                add(buildJsonObject {
                    put("role", "user")
                    put("content", query)
                })
            })
        }

        val rawResponse = client.post("https://api.groq.com/openai/v1/chat/completions") {
            headers {
                append("Authorization", "Bearer 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")
                append("Content-Type", "application/json")
            }
            setBody(payload.toString())
        }.body<String>()

        client.close()

        println("Raw Response: $rawResponse")

        return try {
            // Intenta deserializar la respuesta
            val responseJson = Json.parseToJsonElement(rawResponse).jsonObject
            val choices = responseJson["choices"]?.jsonArray?.firstOrNull()?.jsonObject
            var sqlCode = choices?.get("message")?.jsonObject?.get("content")?.toString() ?: ""



            sqlCode
        } catch (e: Exception) {
            println("Error parsing response: ${e.message}")
            // Intenta parsear el error
            try {
                val errorResponse = Json.decodeFromString<GroqError>(rawResponse)
                "Error from API: ${errorResponse.message}"
            } catch (errorParsingException: Exception) {
                "Error parsing error response: ${errorParsingException.message}"
            }
        }
    }


    // Define las clases necesarias para manejar la respuesta
    @Serializable
    data class GroqError(val message: String, val type: String, val code: String)




}

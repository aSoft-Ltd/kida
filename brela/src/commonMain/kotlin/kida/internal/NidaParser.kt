package kida.internal

import kida.Person
import kida.Sex
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

internal class NidaParser {
    fun parse(resp: String): Person? {
        val jObject = Json.decodeFromString(JsonObject.serializer(), resp)
        val obj = jObject.obj
        val result = obj?.result ?: return null
        return Person(
            name = "${result.name(FIRSTNAME)} ${result.name(MIDDLENAME)} ${result.name(SURNAME)}",
            sex = Sex.values().first { it.name.uppercase() == result.string(SEX) },
            dateOfBirth = result.string(DATEOFBIRTH),
            nationality = result.string(NATIONALITY),
            nin = result.string(NIN)
        )
    }

    companion object {
        private const val FIRSTNAME = "FIRSTNAME"
        private const val MIDDLENAME = "MIDDLENAME"
        private const val SURNAME = "SURNAME"
        private const val SEX = "SEX"
        private const val NATIONALITY = "NATIONALITY"
        private const val DATEOFBIRTH = "DATEOFBIRTH"
        private const val NIN = "NIN"

        private const val OBJ = "obj"
        private val JsonObject.obj get() = get(OBJ)?.jsonObject

        private const val RESULT = "result"
        private val JsonObject.result get() = get(RESULT)?.jsonObject

        private const val ERROR = "error"
        private val JsonObject.error get() = string(ERROR)
        private fun JsonObject.string(key: String) = get(key)?.jsonPrimitive?.content ?: throw RuntimeException("Missing $key")
        private fun JsonObject.name(key: String) = string(key).lowercase().replaceFirstChar { it.uppercase() }
    }
}
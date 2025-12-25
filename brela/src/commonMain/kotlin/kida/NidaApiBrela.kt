package kida

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.statement.bodyAsText
import kida.internal.NidaParser

class NidaApiBrela(
    private val http: HttpClient,
    private val url: String = URL
) : NidaApi {
    private val parser by lazy { NidaParser() }

    override suspend fun info(nin: String): Person? {
        println("Brela no longer allow access to an unauthorised users. Try to find a different provider please")
        throw IllegalStateException("Brela no longer allow access to an unauthorised users. Try to find a different provider please")
        val resp = http.post("$url/$nin")
        val text = resp.bodyAsText()
        return parser.parse(text)
    }

    companion object {
        private const val URL = "https://ors.brela.go.tz/um/load/load_nida"
    }
}
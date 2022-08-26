package kida.internal

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kida.NidaApi
import kida.NidaApiConfig
import kida.Person
import koncurrent.Later
import koncurrent.coroutines.asCoroutineScope
import koncurrent.later

@PublishedApi
internal class NidaApiImpl(private val config: NidaApiConfig) : NidaApi {
    private val scope by lazy { config.executor.asCoroutineScope() }
    private val client by lazy { HttpClient { } }

    private val parser by lazy { NidaParser() }

    override fun info(nin: String): Later<Person> = scope.later {
        val resp = client.post("$URL/$nin")
        val text = resp.bodyAsText()
        parser.parse(text)
    }

    companion object {
        private const val URL = "https://ors.brela.go.tz/um/load/load_nida"
    }
}
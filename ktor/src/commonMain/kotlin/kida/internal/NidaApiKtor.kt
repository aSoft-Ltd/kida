package kida.internal

import io.ktor.client.request.*
import io.ktor.client.statement.*
import kida.NidaApi
import kida.Person
import koncurrent.Later
import koncurrent.coroutines.asCoroutineScope
import koncurrent.later

@PublishedApi
internal class NidaApiKtor(private val config: NidaApiKtorConfig) : NidaApi {
    private val scope by lazy { config.executor.asCoroutineScope() }

    private val parser by lazy { NidaParser() }

    override fun info(nin: String): Later<Person> = scope.later {
        val resp = config.client.post("$URL/$nin")
        val text = resp.bodyAsText()
        parser.parse(text)
    }

    companion object {
        private const val URL = "https://ors.brela.go.tz/um/load/load_nida"
    }
}
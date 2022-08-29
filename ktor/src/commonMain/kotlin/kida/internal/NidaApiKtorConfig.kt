package kida.internal

import io.ktor.client.*
import kida.NidaApiConfig
import koncurrent.Executor

@PublishedApi
internal class NidaApiKtorConfig(
    val client: HttpClient,
    override val executor: Executor
) : NidaApiConfig
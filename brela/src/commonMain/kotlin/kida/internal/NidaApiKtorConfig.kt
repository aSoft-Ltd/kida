package kida.internal

import io.ktor.client.*
import koncurrent.Executor

@PublishedApi
internal class NidaApiKtorConfig(
    val client: HttpClient,
    val executor: Executor
)
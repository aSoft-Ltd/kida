@file:Suppress("NOTHING_TO_INLINE")

package kida.ktor

import io.ktor.client.*
import kida.NidaApi
import kida.internal.NidaApiKtorConfig
import kida.internal.NidaApiKtor
import koncurrent.Executor
import koncurrent.Executors

inline fun NidaApi(
    client: HttpClient = HttpClient { },
    executor: Executor = Executors.default()
): NidaApi = NidaApiKtor(NidaApiKtorConfig(client, executor))
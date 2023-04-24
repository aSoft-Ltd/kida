@file:Suppress("NOTHING_TO_INLINE")

package kida

import io.ktor.client.*
import kida.internal.NidaApiKtorConfig
import kida.internal.NidaApiBrela
import koncurrent.Executor
import koncurrent.Executors

inline fun NidaApiBrela(
    client: HttpClient = HttpClient { },
    executor: Executor = Executors.default()
): NidaApi = NidaApiBrela(NidaApiKtorConfig(client, executor))
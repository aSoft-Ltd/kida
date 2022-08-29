@file:Suppress("NOTHING_TO_INLINE")

package kida

import io.ktor.client.*
import koncurrent.Executor
import koncurrent.Executors

inline fun NidaApi(
    client: HttpClient = HttpClient { },
    executor: Executor = Executors.default()
): NidaApi = kida.ktor.NidaApi(client, executor)
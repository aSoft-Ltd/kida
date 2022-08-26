@file:Suppress("NOTHING_TO_INLINE")

package kida

import kida.internal.NidaApiConfigImpl
import kida.internal.NidaApiImpl
import kida.internal.PersonImpl
import koncurrent.Executor
import koncurrent.Executors

inline fun Person(
    name: String,
    sex: Sex,
    dateOfBirth: String,
    nationality: String,
    nin: String
): Person = PersonImpl(name, sex, dateOfBirth, nationality, nin)

inline fun NidaApiConfig(
    executor: Executor = Executors.default()
): NidaApiConfig = NidaApiConfigImpl(executor)

inline fun NidaApi(
    config: NidaApiConfig = NidaApiConfig()
): NidaApi = NidaApiImpl(config)
package kida

import koncurrent.Later
import koncurrent.later

class NidaApiFake(
    private val config: NidaApiFakeConfig = NidaApiFakeConfig()
) : NidaApi {
    override fun info(nin: String): Later<PersonInfo> = config.executor.later {
        val pi = config.fakes.find { it.nin == nin }
        pi ?: throw IllegalArgumentException("Missing person")
    }

    override fun toString(): String = "NidaApiFake"
}
package kida

import koncurrent.Later

class NidaApiFake : NidaApi {
    override fun info(nin: String): Later<Any> {
        TODO("Not yet implemented")
    }

    override fun toString(): String = "NidaApiFake"
}
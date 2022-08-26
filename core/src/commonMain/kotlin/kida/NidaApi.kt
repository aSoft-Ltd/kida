package kida

import koncurrent.Later

interface NidaApi {
    fun info(nin: String): Later<Any>
}
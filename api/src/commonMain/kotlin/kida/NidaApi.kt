@file:Suppress("NON_EXPORTABLE_TYPE")

package kida

import koncurrent.Later
import kotlin.js.JsExport

//@JsExport
interface NidaApi {
    fun info(nin: String): Later<Person>
}
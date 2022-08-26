package kida

import kotlin.js.JsExport

@JsExport
interface PersonInfo {
    val name: String
    val sex: Sex
    val dateOfBirth: String
    val nationality: String
    val nin: String
}
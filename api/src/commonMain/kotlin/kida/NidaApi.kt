package kida


//@JsExport
interface NidaApi {
    suspend fun info(nin: String): Person?
}
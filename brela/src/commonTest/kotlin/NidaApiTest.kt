import io.ktor.client.HttpClient
import kida.NidaApiBrela
import kotlinx.coroutines.test.runTest
import kotlin.test.Ignore
import kotlin.test.Test

class NidaApiTest {

    val api = NidaApiBrela(
        http = HttpClient {}
    )

    @Test
    @Ignore
    fun should_fetch_data() = runTest {
        val res = api.info("03923093098423456895")
        println(res)
    }
}
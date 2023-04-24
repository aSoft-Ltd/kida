import kommander.expect
import kida.NidaApiBrela
import koncurrent.later.await
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class NidaApiTest {

    val api = NidaApiBrela()

    @Test
    @Ignore
    fun should_fetch_data() = runTest {
        val res = api.info("03923093098423456895").await()
        println(res)
    }
}
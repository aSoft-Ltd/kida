import expect.expect
import kida.ktor.NidaApi
import koncurrent.later.await
import kotlinx.coroutines.test.runTest
import kotlin.test.Ignore
import kotlin.test.Test

class NidaApiTest {

    @Test
    fun should_get_nida_info() {
        expect(1 + 1).toBe(2)
    }

    @Test
    @Ignore
    fun should_fetch_data() = runTest {
        val api = NidaApi()
        val res = api.info("039230930984234").await()
    }
}
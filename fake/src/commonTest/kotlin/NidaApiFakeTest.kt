import kida.NidaApi
import kida.NidaApiFake
import kommander.expect
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class NidaApiFakeTest {

    val api: NidaApi = NidaApiFake()

    @Test
    fun should_return_a_response_for_a_valid_nin() = runTest {
        val p1 = api.info(nin = "19900101000000000001")
        expect(p1?.name).toBe("John Makongoro Doe")

        val p2 = api.info(nin = "19900101000000000002")
        expect(p2?.name).toBe("Jane Makukuru Doe")
    }
}
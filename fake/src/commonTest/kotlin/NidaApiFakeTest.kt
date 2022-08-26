import expect.expect
import kida.NidaApiFake
import koncurrent.later.test
import kotlin.test.Test

class NidaApiFakeTest {

    @Test
    fun should_return_a_response_for_a_valid_nin() {
        val api = NidaApiFake()

        api.info(nin = "19900101000000000001").then { person ->
            println(person)
            expect(person.name).toBe("John Makongoro Doe")
        }.test()

        api.info(nin = "19900101000000000002").then { person ->
            println(person)
            expect(person.name).toBe("Jane Makukuru Doe")
        }.test()
    }
}
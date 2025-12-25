package kida


class NidaApiFake(
    val fakes: MutableList<Person> = DEFAULT_FAKES
) : NidaApi {
    companion object {
        val DEFAULT_FAKES = mutableListOf(
            Person(
                nin = "19900101000000000001",
                name = "John Makongoro Doe",
                sex = Sex.Male,
                dateOfBirth = "1990-01-01",
                nationality = "TANZANIAN",
            ),
            Person(
                nin = "19900101000000000002",
                name = "Jane Makukuru Doe",
                sex = Sex.Male,
                dateOfBirth = "1990-01-01",
                nationality = "TANZANIAN",
            ),
        )
    }

    override suspend fun info(nin: String): Person? = fakes.find { it.nin == nin }

    override fun toString(): String = "NidaApiFake"
}
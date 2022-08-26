package kida

import koncurrent.Executor
import koncurrent.SynchronousExecutor
import kotlinx.collections.interoperable.List
import kotlinx.collections.interoperable.iListOf

class NidaApiFakeConfig(
    override val executor: Executor = SynchronousExecutor,
    val fakes: List<PersonInfo> = DEFAULT_FAKES
) : NidaApiConfig {
    companion object {
        val DEFAULT_FAKES = iListOf(
            PersonInfo(
                nin = "19900101000000000001",
                name = "John Makongoro Doe",
                sex = Sex.Male,
                dateOfBirth = "1990-01-01",
                nationality = "TANZANIAN",
            ),
            PersonInfo(
                nin = "19900101000000000002",
                name = "Jane Makukuru Doe",
                sex = Sex.Male,
                dateOfBirth = "1990-01-01",
                nationality = "TANZANIAN",
            ),
        )
    }
}
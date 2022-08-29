package kida.internal

import kida.Person
import kida.Sex

@PublishedApi
internal data class PersonImpl(
    override val name: String,
    override val sex: Sex,
    override val dateOfBirth: String,
    override val nationality: String,
    override val nin: String
) : Person
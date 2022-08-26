package kida.internal

import kida.PersonInfo
import kida.Sex

@PublishedApi
internal data class PersonInfoImpl(
    override val name: String,
    override val sex: Sex,
    override val dateOfBirth: String,
    override val nationality: String,
    override val nin: String
) : PersonInfo
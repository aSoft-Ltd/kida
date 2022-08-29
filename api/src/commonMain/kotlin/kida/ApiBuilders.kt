@file:Suppress("NOTHING_TO_INLINE")

package kida

import kida.internal.PersonImpl

inline fun Person(
    name: String,
    sex: Sex,
    dateOfBirth: String,
    nationality: String,
    nin: String
): Person = PersonImpl(name, sex, dateOfBirth, nationality, nin)
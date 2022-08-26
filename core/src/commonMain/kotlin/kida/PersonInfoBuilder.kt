package kida

import kida.internal.PersonInfoImpl

inline fun PersonInfo(
    name: String,
    sex: Sex,
    dateOfBirth: String,
    nationality: String,
    nin: String
): PersonInfo = PersonInfoImpl(name, sex, dateOfBirth, nationality, nin)
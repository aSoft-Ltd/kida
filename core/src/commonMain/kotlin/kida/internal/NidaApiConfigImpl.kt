package kida.internal

import kida.NidaApiConfig
import koncurrent.Executor

class NidaApiConfigImpl(
    override val executor: Executor
) : NidaApiConfig
package com.kubsau.regrab.network

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin

actual class KtorEngineFactory {
    actual fun getEngine(): HttpClientEngineFactory<*> = Darwin
}
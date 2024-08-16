package com.kubsau.regrab.network

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.okhttp.OkHttp

actual class KtorEngineFactory {
    actual fun getEngine(): HttpClientEngineFactory<*> = OkHttp
}
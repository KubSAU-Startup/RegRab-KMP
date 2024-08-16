package com.kubsau.regrab.network

import io.ktor.client.engine.HttpClientEngineFactory

expect class KtorEngineFactory() {
    fun getEngine(): HttpClientEngineFactory<*>
}
package com.kubsau.regrab.di.modules

import com.kubsau.regrab.network.KtorEngineFactory
import com.kubsau.regrab.network.NetworkRepo
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorEngineFactory)

    single {
        HttpClient(engineFactory = get<KtorEngineFactory>().getEngine()) {
            defaultRequest {
                url("https://kubsau-testbackend.melod1n.dedyn.io/")
                contentType(ContentType.Application.FormUrlEncoded)
            }

            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }

            install(ContentNegotiation) {
                json()
            }
        }
    }

    singleOf(::NetworkRepo)
}
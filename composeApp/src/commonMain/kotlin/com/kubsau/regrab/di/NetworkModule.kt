package com.kubsau.regrab.di

import com.kubsau.regrab.network.NetworkRepo
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient {
            defaultRequest {
                url("https://kubsau-testbackend.melod1n.dedyn.io/")
            }

            install(ContentNegotiation) {
                json()
            }
        }
    }

    singleOf(::NetworkRepo)
}
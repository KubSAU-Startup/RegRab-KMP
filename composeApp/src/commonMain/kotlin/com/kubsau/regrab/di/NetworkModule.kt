package com.kubsau.regrab.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.defaultRequest
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient {
            defaultRequest {
                url("https://kubsau-testbackend.melod1n.dedyn.io/")
            }
        }
    }
}
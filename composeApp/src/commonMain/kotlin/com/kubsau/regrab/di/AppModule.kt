package com.kubsau.regrab.di

import com.kubsau.regrab.di.modules.navigationModule
import com.kubsau.regrab.di.modules.networkModule
import com.kubsau.regrab.di.modules.screenModelModule
import com.kubsau.regrab.di.modules.storageModule
import org.koin.dsl.module

val appModule = module {
    includes(
        navigationModule,
        networkModule,
        screenModelModule,
        storageModule
    )
}
package com.kubsau.regrab.di

import com.kubsau.regrab.ui.auth.AuthScreenModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val screenModelModule = module {
//    singleOf(::TestScreenModel)
    singleOf(::AuthScreenModel)
}
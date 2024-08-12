package com.kubsau.regrab.di

import com.kubsau.regrab.ui.auth.AuthScreenModel
import com.kubsau.regrab.ui.test.TestScreenModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val screenModelModule = module {
//    singleOf(::TestScreenModel)
    singleOf(::AuthScreenModel)
}
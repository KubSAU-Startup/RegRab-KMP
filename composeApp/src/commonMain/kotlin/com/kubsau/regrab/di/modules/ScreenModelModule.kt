package com.kubsau.regrab.di.modules

import com.kubsau.regrab.ui.auth.AuthScreenModel
import com.kubsau.regrab.ui.main.MainScreenModel
import com.kubsau.regrab.ui.test.TestScreenModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val screenModelModule = module {
    singleOf(::AuthScreenModel)
    singleOf(::TestScreenModel)
    singleOf(::MainScreenModel)
}
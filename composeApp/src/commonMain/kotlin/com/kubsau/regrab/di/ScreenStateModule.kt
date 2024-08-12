package com.kubsau.regrab.di

import com.kubsau.regrab.ui.test.TestScreenModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val screenstateModule = module {
    singleOf(::TestScreenModel)
}
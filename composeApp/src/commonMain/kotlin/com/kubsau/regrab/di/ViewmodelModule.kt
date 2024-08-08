package com.kubsau.regrab.di

import com.kubsau.regrab.ui.test.TestVM
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val viewmodelModule = module {
    singleOf(::TestVM)
}
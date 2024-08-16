package com.kubsau.regrab.di.modules

import com.kubsau.regrab.storage.AccountStorage
import com.kubsau.regrab.storage.AccountStorageImpl
import com.kubsau.regrab.storage.AccountStorageProvider
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val storageModule = module {
    single { AccountStorageProvider().getStorage() }
    singleOf(::AccountStorageImpl) bind AccountStorage::class
}
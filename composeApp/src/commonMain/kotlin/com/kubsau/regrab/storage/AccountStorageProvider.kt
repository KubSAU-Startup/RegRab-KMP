package com.kubsau.regrab.storage

import io.github.xxfast.kstore.KStore

expect class AccountStorageProvider() {
    fun getStorage(): KStore<AccountStoreModel>
}
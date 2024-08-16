package com.kubsau.regrab.storage

import com.kubsau.regrab.appDir
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import okio.Path.Companion.toPath

actual class AccountStorageProvider {
    actual fun getStorage(): KStore<AccountStoreModel> {
        return storeOf(file = "$appDir/account.json".toPath())
    }
}
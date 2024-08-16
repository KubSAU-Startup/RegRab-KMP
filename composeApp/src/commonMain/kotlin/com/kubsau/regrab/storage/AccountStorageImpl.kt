package com.kubsau.regrab.storage

import io.github.xxfast.kstore.KStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface AccountStorage {
    val account: StateFlow<AccountStoreModel>

    suspend fun saveAccount()
    suspend fun updateAccount(update: (AccountStoreModel) -> AccountStoreModel)
    suspend fun getToken(): String
}

class AccountStorageImpl(
    private val store: KStore<AccountStoreModel>
) : AccountStorage {
    override val account = MutableStateFlow(AccountStoreModel.EMPTY)

    override suspend fun saveAccount() {
        store.set(account.value)
    }

    override suspend fun updateAccount(update: (AccountStoreModel) -> AccountStoreModel) {
        store.set(update(account.value))
    }

    override suspend fun getToken(): String {
        return store.get()?.token.toString()
    }
}
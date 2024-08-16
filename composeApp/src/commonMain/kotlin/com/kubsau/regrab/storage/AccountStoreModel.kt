package com.kubsau.regrab.storage

import kotlinx.serialization.Serializable

@Serializable
data class AccountStoreModel(
    val token: String? = null
) {
    companion object {
        val EMPTY = AccountStoreModel()
    }
}
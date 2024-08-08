package com.kubsau.regrab.network.models.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    @SerialName("userId") val id: Int,
    val accessToken: String,
    val facultyId: Int,
    val departmentIds: List<Int>,
    val selectedDepartmentId: Int,
)

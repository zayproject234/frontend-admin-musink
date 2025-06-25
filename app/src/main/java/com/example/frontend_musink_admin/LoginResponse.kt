package com.example.frontend_musink_admin

data class LoginResponse(
    val status: Int,
    val message: String,
    val data: UserData
)

data class UserData(
    val id: Int,
    val username: String,
    val email: String,
    val phoneNumber: String,
    val profilePicture: String?, // nullable karena nilainya null
    val role: String,
    val createdAt: String
)

package com.example.frontend_musink_admin

data class Booking(
    val id: String,
    val date: String,
    val time: String,
    val status: String = "pending" // ⬅️ nilai default
)

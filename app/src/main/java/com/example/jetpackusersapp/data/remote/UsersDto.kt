package com.example.jetpackusersapp.data.remote


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UsersDto(
    val users: List<User?>?
)
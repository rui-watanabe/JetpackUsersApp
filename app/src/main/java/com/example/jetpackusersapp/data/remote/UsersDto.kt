package com.example.jetpackusersapp.data.remote


import com.example.jetpackusersapp.domain.model.User
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UsersDto(
    val users: List<User?>?
)

fun UsersDto.toUsers(): List<User> {
    return users!!.map {
        User(
            id = it!!.id,
            name = it.name
        )
    }
}
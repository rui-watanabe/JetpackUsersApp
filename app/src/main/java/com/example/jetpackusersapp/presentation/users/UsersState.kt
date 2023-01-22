package com.example.jetpackusersapp.presentation.users

import com.example.jetpackusersapp.domain.model.User

data class UsersState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String? = null
)

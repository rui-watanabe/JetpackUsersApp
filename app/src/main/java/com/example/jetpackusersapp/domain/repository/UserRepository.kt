package com.example.jetpackusersapp.domain.repository

import com.example.jetpackusersapp.data.remote.UsersDto

interface UserRepository {
    suspend fun getUsers(): UsersDto
}
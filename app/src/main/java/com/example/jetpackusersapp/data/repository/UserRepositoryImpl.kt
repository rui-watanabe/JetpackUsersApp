package com.example.jetpackusersapp.data.repository

import com.example.jetpackusersapp.data.remote.UserApi
import com.example.jetpackusersapp.data.remote.UsersDto
import com.example.jetpackusersapp.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor (
    private val userApi: UserApi
        ): UserRepository {
    override suspend fun getUsers(): UsersDto {
        return userApi.getUsers()
    }
}
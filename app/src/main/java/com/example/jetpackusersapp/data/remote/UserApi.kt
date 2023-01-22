package com.example.jetpackusersapp.data.remote

import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getUsers(): UsersDto
}
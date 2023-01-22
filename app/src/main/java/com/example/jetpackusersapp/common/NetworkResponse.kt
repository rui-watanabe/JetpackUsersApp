package com.example.jetpackusersapp.common

sealed class NetworkResponse<T>(
    val data: T? = null,
    var error: String? = null
) {
    class Success<T>(data: T): NetworkResponse<T>(data = data)
    class Failure<T>(error: String): NetworkResponse<T>(error = error)
    class Loading<T>: NetworkResponse<T>()
}

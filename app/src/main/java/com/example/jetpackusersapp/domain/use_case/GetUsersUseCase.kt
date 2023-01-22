package com.example.jetpackusersapp.domain.use_case

import com.example.jetpackusersapp.common.NetworkResponse
import com.example.jetpackusersapp.data.remote.toUsers
import com.example.jetpackusersapp.domain.model.User
import com.example.jetpackusersapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(): Flow<NetworkResponse<List<User>>> = flow {
        try {
            emit(NetworkResponse.Loading<List<User>>())
            val users = userRepository.getUsers().toUsers()
            emit(NetworkResponse.Success<List<User>>(users))
        } catch (error: Exception) {
            emit(NetworkResponse.Failure<List<User>>(error.message.toString()))
        }
    }

    fun onEach(any: Any) {

    }
}
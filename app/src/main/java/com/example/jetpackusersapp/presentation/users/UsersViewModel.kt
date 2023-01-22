package com.example.jetpackusersapp.presentation.users

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.jetpackusersapp.domain.use_case.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.State
import com.example.jetpackusersapp.common.NetworkResponse
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val useCase: GetUsersUseCase
): ViewModel() {
    private val _state = mutableStateOf(UsersState())
    val state: State<UsersState> = _state

    fun getUsers() {
        useCase().onEach { result ->
            when(result) {
                is NetworkResponse.Success -> {
                    _state.value = UsersState(
                        isLoading = false,
                        users = result.data ?: emptyList()
                    )
                }
                is NetworkResponse.Failure ->{
                    _state.value = UsersState(
                        isLoading = false,
                        error = result.error
                    )
                }
                is NetworkResponse.Loading ->{
                    _state.value = UsersState(
                        isLoading = true
                    )
                }
            }
        }
    }

}
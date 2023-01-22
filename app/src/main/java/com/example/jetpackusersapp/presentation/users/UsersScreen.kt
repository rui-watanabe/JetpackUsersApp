package com.example.jetpackusersapp.presentation.users

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun UsersScreen(viewModel: UsersViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    LazyColumn {
        items(state.users) { user ->
            Text(text = user.name)
        }
    }
}
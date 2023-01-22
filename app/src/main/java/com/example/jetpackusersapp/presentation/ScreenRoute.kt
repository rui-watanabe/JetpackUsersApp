package com.example.jetpackusersapp.presentation

sealed class ScreenRoute(val route: String) {
    object UsersScreen: ScreenRoute("users_screen")
}

package com.example.dyplomapp.presentation.hight_level_screen.loginScreen


sealed class LoginEvent {
    data class EnteredLogin(val loginText: String): LoginEvent()
    data class EntedPassword(val passwordText: String): LoginEvent()
    object TogglePasswordVisibility: LoginEvent()
    object Login: LoginEvent()
}
package com.example.dyplomapp.presentation.loginScreen


sealed class LoginEvent {
    data class EnteredLogin(val loginText: String): LoginEvent()
    data class EntedPassword(val passwordText: String): LoginEvent()
    object TogglePasswordVisibility: LoginEvent()
    object Login: LoginEvent()
}
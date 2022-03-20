package com.example.dyplomapp.presentation.hight_level_screen.register_data_set_screen




sealed class RegisterDataEvent {
    data class EnteredEmail(val emailText: String): RegisterDataEvent()
    data class EnteredPassword(val passwordText: String): RegisterDataEvent()
    data class EnteredRepeatPassword(val repeatPasswordText: String): RegisterDataEvent()
    object TogglePasswordVisibility: RegisterDataEvent()
    object ToggleRepeatPasswordVisibility: RegisterDataEvent()
    object Register: RegisterDataEvent()
}
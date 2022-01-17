package com.example.dyplomapp.presentation.register_screen

sealed class RegisterEvent{
    data class EnteredInviteCode(val inviteCode: String): RegisterEvent()
    object TogglePasswordVisibility: RegisterEvent()
    object Register: RegisterEvent()
}

package com.example.dyplomapp.presentation.hight_level_screen.onBoarding_screen.register_screen

sealed class RegisterEvent{
    data class EnteredInviteCode(val inviteCode: String): RegisterEvent()
    object Register: RegisterEvent()
}

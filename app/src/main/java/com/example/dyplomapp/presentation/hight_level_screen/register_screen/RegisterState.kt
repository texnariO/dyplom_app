package com.example.dyplomapp.presentation.hight_level_screen.onBoarding_screen.register_screen

import com.example.dyplomapp.di.DatabaseApi

data class RegisterState(
    var api: DatabaseApi,
    var userInviteCode: String = "",
    val userInviteCodeError: UserInviteCodeError? = null,
    val id_inviteCode: Int? = null,
    val isLoading: Boolean = false
){
    sealed class UserInviteCodeError{
        object FieldEmpty: UserInviteCodeError()
        object InputTooShor: UserInviteCodeError()
        object InvalidCode: UserInviteCodeError()
    }
}

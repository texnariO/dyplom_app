package com.example.dyplomapp.presentation.register_screen

data class RegisterState(
    var userInviteCode: String = "",
    val userInviteCodeError: UserInviteCodeError? = null
){
    sealed class UserInviteCodeError{
        object FieldEmpty: UserInviteCodeError()
        object InputTooShor: UserInviteCodeError()
        object InvalidCode: UserInviteCodeError()
    }
}

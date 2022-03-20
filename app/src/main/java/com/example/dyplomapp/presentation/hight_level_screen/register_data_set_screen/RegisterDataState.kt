package com.example.dyplomapp.presentation.hight_level_screen.register_data_set_screen

import com.example.dyplomapp.di.DatabaseApi

data class RegisterDataState(
    var api: DatabaseApi,
    var is_Loading: Boolean = false,
    var id_inviteCode: Int = 0,
    var userEmail: String = "",
    var userEmailError: UserEmailError? = null,
    var passwordRegister: String = "",
    var passwordRegisterError: PasswordRegisterError? = null,
    var passwordRepeatRegister: String = "",
    var passwordRepeatRegisterError: PasswordRegisterError? = null,
    var isPasswordVisible: Boolean = false,
    var isPasswordRepeatVisible: Boolean = false
){
    sealed class UserEmailError{
        object FieldEmpty: UserEmailError()
        object InvalidEmail: UserEmailError()
        object EmailNotUniq: UserEmailError()
    }
    sealed class PasswordRegisterError{
        object FieldEmpty: PasswordRegisterError()
        object InputTooShort: PasswordRegisterError()
        object InvalidPasswordType: PasswordRegisterError()
        object RepeatPasswordNotCorrect: PasswordRegisterError()
        object InvalidPasswordBase: PasswordRegisterError()
    }
}
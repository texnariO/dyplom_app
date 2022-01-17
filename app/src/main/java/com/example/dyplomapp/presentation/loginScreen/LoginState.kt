package com.example.dyplomapp.presentation.loginScreen

data class LoginState(
    var userLogin: String = "",
    var userLoginError: UserLoginError? = null,
    var passwordLogin: String = "",
    var passwordLoginError: PasswordLoginError? = null,
    var isPasswordVisible: Boolean = false
){
    sealed class UserLoginError{
        object FieldEmpty: UserLoginError()
        object InputTooShort: UserLoginError()
        object InvalidLoginBase: UserLoginError()
    }

    sealed class PasswordLoginError{
        object FieldEmpty: PasswordLoginError()
        object InputTooShort: PasswordLoginError()
        object InvalidPasswordType: PasswordLoginError()
        object InvalidPasswordBase: PasswordLoginError()
    }
}
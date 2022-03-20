package com.example.dyplomapp.presentation.hight_level_screen.loginScreen

import android.util.Patterns
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.dyplomapp.presentation.hight_level_screen.register_data_set_screen.RegisterDataState
import com.example.dyplomapp.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    fun onEvent(event: LoginEvent){
        when(event){
            is LoginEvent.EnteredLogin -> {
                _state.value = _state.value.copy(
                    userLogin = event.loginText
                )
            }
            is LoginEvent.EntedPassword -> {
                _state.value = _state.value.copy(
                    passwordLogin = event.passwordText
                )
            }
            is LoginEvent.Login -> {
                validateLogin(state.value.userLogin)
                validatePassword(state.value.passwordLogin)
            }

            is LoginEvent.TogglePasswordVisibility -> {
                _state.value = _state.value.copy(
                    isPasswordVisible = !state.value.isPasswordVisible
                )
            }
        }
    }

    private fun validateLogin(login: String){
        val loginTrimmed = login.trim()
        if(loginTrimmed.isBlank()){
            _state.value = _state.value.copy(
                userLoginError = LoginState.UserLoginError.FieldEmpty
            )
            return
        }
        if(loginTrimmed.length < Constants.MIN_LOGIN_LENGTH){
            _state.value = _state.value.copy(
                userLoginError = LoginState.UserLoginError.InputTooShort
            )
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(loginTrimmed).matches()){
            _state.value = _state.value.copy(
                userLoginError = LoginState.UserLoginError.InvalidLoginBase
            )
            return
        }
        //TODO check from database
        _state.value = _state.value.copy(userLoginError = null)
    }

    private fun validatePassword(password: String){
        if(password.isBlank()){
            _state.value = _state.value.copy(
                passwordLoginError = LoginState.PasswordLoginError.FieldEmpty
            )
            return
        }
        if(password.length < Constants.MIN_CODE_LENGTH){
            _state.value = _state.value.copy(
                passwordLoginError = LoginState.PasswordLoginError.InputTooShort
            )
            return
        }
        var capitalLettersInPassword = password.any{
            it.isUpperCase()
        }
        var numberInPassword = password.any {
            it.isDigit()
        }
        if(!capitalLettersInPassword || !numberInPassword){
            _state.value = _state.value.copy(
                passwordLoginError = LoginState.PasswordLoginError.InvalidPasswordType
            )
            return
        }

        //TODO valid password from database
        _state.value = _state.value.copy(passwordLoginError = null)
    }
}
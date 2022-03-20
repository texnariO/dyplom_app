package com.example.dyplomapp.presentation.hight_level_screen.register_data_set_screen


import android.util.Patterns
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dyplomapp.di.DatabaseApi
import com.example.dyplomapp.di.models.UserData
import com.example.dyplomapp.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.regex.Pattern


@HiltViewModel
class RegisterDataViewModel @Inject constructor(
    private val api: DatabaseApi
) : ViewModel() {
    private val _state = mutableStateOf(RegisterDataState(api))
    val state: State<RegisterDataState> = _state

    fun onEvent(event: RegisterDataEvent){
        when(event){
            is RegisterDataEvent.EnteredEmail ->{
                _state.value = _state.value.copy(
                    userEmail = event.emailText
                )
            }
            is RegisterDataEvent.EnteredPassword ->{
                _state.value = _state.value.copy(
                    passwordRegister = event.passwordText
                )
            }
            is RegisterDataEvent.EnteredRepeatPassword ->{
                _state.value = _state.value.copy(
                    passwordRepeatRegister = event.repeatPasswordText
                )
            }
            is RegisterDataEvent.TogglePasswordVisibility ->{
                _state.value = _state.value.copy(
                    isPasswordVisible = !state.value.isPasswordVisible
                )
            }
            is RegisterDataEvent.ToggleRepeatPasswordVisibility ->{
                _state.value = _state.value.copy(
                    isPasswordRepeatVisible = !state.value.isPasswordRepeatVisible
                )
            }
            is RegisterDataEvent.Register -> {
                validateEmail(state.value.userEmail)
                validatePassowrds(state.value.passwordRegister,state.value.passwordRepeatRegister)
                if(state.value.userEmailError == null
                    && state.value.passwordRegisterError == null
                    && state.value.passwordRepeatRegisterError == null)
                    modifierDatabase(state.value.id_inviteCode,state.value.userEmail,state.value.passwordRegister)
            }
        }
    }

    private fun modifierDatabase(id: Int,email: String,password: String){
        _state.value = _state.value.copy(
            is_Loading = true
        )
        viewModelScope.launch {
            val request = _state.value.api.registerUser(UserData(id,email,password))
            if(request.isSuccessful){
                //TODO
            }
            else {
                if (request.message().equals("Confict")) {
                    _state.value = _state.value.copy(
                        userEmailError = RegisterDataState.UserEmailError.EmailNotUniq,
                        is_Loading = false
                    )
                    Timber.tag("RegisterDataViewModel",).e("User with this email exist")
                }else{
                    _state.value = _state.value.copy(
                        userEmailError = RegisterDataState.UserEmailError.EmailNotUniq,
                        is_Loading = false
                    )
                    Timber.tag("RegisterDataViewModel").e("Internet Error")
                }
            }
        }
    }

    private fun validatePassowrds(password: String,passwordRepeat: String){
        _state.value = _state.value.copy(
            passwordRegisterError = null,
            passwordRepeatRegisterError = null
        )
        if(password.isBlank()){
            _state.value = _state.value.copy(
                passwordRegisterError = RegisterDataState.PasswordRegisterError.FieldEmpty
            )
            return
        }
        if(password.length < Constants.MIN_CODE_LENGTH){
            _state.value = _state.value.copy(
                passwordRegisterError = RegisterDataState.PasswordRegisterError.InputTooShort
            )
            return
        }
        val capitalLetersInPassword = password.any{
            it.isUpperCase()
        }
        val numberInPassword = password.any{
            it.isDigit()
        }
        if(!capitalLetersInPassword || !numberInPassword){
            _state.value = _state.value.copy(
                passwordRegisterError = RegisterDataState.PasswordRegisterError.InvalidPasswordType
            )
            return
        }
        if(password != passwordRepeat){
          _state.value = _state.value.copy(
              passwordRegisterError = RegisterDataState.PasswordRegisterError.RepeatPasswordNotCorrect,
              passwordRepeatRegisterError = RegisterDataState.PasswordRegisterError.RepeatPasswordNotCorrect
          )
          return
        }

    }


    private fun validateEmail(email: String){
        val emailTrimmed = email.trim()
        _state.value = _state.value.copy(
            userEmailError = null
        )
        if(emailTrimmed.isBlank()){
            _state.value = _state.value.copy(
                userEmailError = RegisterDataState.UserEmailError.FieldEmpty
            )
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emailTrimmed).matches()){
            _state.value = _state.value.copy(
                userEmailError = RegisterDataState.UserEmailError.InvalidEmail
            )
            return
        }

    }
}
package com.example.dyplomapp.presentation.register_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.dyplomapp.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {
    private val _state = mutableStateOf(RegisterState())
    val state: State<RegisterState> = _state

    fun onEvent(event: RegisterEvent){
        when(event){
            is RegisterEvent.EnteredInviteCode -> {
                _state.value = _state.value.copy(
                    userInviteCode = event.inviteCode
                )
            }
            is RegisterEvent.Register -> {
                validateInviteCode(state.value.userInviteCode)
            }
        }
    }

    private fun validateInviteCode(inviteCode: String){
        if(inviteCode.isBlank()){
            _state.value = _state.value.copy(
                userInviteCodeError = RegisterState.UserInviteCodeError.FieldEmpty
            )
            return
        }
        if(inviteCode.length < Constants.MIN_CODE_LENGTH){
            _state.value = _state.value.copy(
                userInviteCodeError = RegisterState.UserInviteCodeError.InputTooShor
            )
            return
        }
        val numberInCode = inviteCode.any{ it.isDigit() }
        if (!numberInCode){
            _state.value = _state.value.copy(
                userInviteCodeError =  RegisterState.UserInviteCodeError.InvalidCode
            )
            return
        }
        //TODO Check in DataBase
        _state.value = _state.value.copy(userInviteCodeError = null)

    }
}
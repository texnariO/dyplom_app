package com.example.dyplomapp.presentation.hight_level_screen.register_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dyplomapp.di.DatabaseApi
import com.example.dyplomapp.di.models.SimpleRequest
import com.example.dyplomapp.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val api: DatabaseApi
): ViewModel() {
    private val _state = mutableStateOf(RegisterState(api))
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
                userInviteCodeError =  RegisterState.UserInviteCodeError.InvalidCode,
            )
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            _state.value = _state.value.copy(
                isLoading = true
            )
            try {
                val requestBody = _state.value.api.checkInviteCode(inviteCode)
                if(requestBody.isSuccessful){
                    if(requestBody.body()?.success == true){
                        _state.value = _state.value.copy(id_inviteCode = requestBody.body()!!.message.toInt(),userInviteCodeError = null, isLoading = false)
                    }else{
                        _state.value = _state.value.copy(
                            userInviteCodeError = RegisterState.UserInviteCodeError.InvalidCode,
                            isLoading = false
                        )
                    }
                }
            }catch (e: Exception) {
                _state.value = _state.value.copy(
                    userInviteCodeError = RegisterState.UserInviteCodeError.InvalidCode,
                    isLoading = false
                )
                Timber.tag("InviteCodeViewModel").e(e, "Check Invite Code")
            }
        }
    }
}
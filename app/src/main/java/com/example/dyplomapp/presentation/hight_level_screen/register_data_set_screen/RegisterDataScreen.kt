package com.example.dyplomapp.presentation.hight_level_screen.register_data_set_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import com.example.dyplomapp.R
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dyplomapp.data.BottomNavItem
import com.example.dyplomapp.presentation.components.StandartOutlinedTextField
import com.example.dyplomapp.presentation.theme.Components
import com.example.dyplomapp.presentation.theme.Primary
import com.example.dyplomapp.presentation.theme.SpaseLarge
import com.example.dyplomapp.presentation.theme.SpaseMedium

//@Preview(showBackground = true)
@Composable
fun RegisterDataScreen(
    navController: NavController,
    idInviteCode: Int,
    viewModel: RegisterDataViewModel = hiltViewModel()
) {
    viewModel.state.value.id_inviteCode = idInviteCode
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = SpaseLarge,
                end = SpaseLarge,
                top = SpaseLarge,
                bottom = 50.dp
            )
            .background(Primary)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 25.dp)
        ){
            Spacer(modifier = Modifier.height(SpaseLarge))
            Text(
                text = stringResource(id = R.string.register),
                style = MaterialTheme.typography.h2,
                modifier = Modifier.align(CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(SpaseLarge))
            StandartOutlinedTextField(
                text = state.userEmail,
                onValueChange = {
                    viewModel.onEvent(RegisterDataEvent.EnteredEmail(it))
                },
                error = when(state.userEmailError){
                    RegisterDataState.UserEmailError.FieldEmpty -> {
                        stringResource(id = R.string.this_field_cant_be_empty)
                    }
                    RegisterDataState.UserEmailError.InvalidEmail -> {
                        stringResource(id = R.string.input_invalid_email)
                    }
                    null -> ""
                    RegisterDataState.UserEmailError.EmailNotUniq -> {
                        stringResource(id = R.string.input_not_uniq_email)
                    }
                },
                keyboardType = KeyboardType.Email,
                hint = stringResource(id = R.string.email)
            )
            Spacer(modifier = Modifier.height(SpaseMedium))
            StandartOutlinedTextField(
                text = state.passwordRegister,
                onValueChange = {
                    viewModel.onEvent(RegisterDataEvent.EnteredPassword(it))
                },
                error = when(state.passwordRegisterError){
                    RegisterDataState.PasswordRegisterError.FieldEmpty -> {
                        stringResource(id = R.string.this_field_cant_be_empty)
                    }
                    RegisterDataState.PasswordRegisterError.InputTooShort -> {
                        stringResource(id = R.string.input_too_short_password)
                    }
                    RegisterDataState.PasswordRegisterError.InvalidPasswordBase -> {
                        stringResource(id = R.string.input_invalid_password)
                    }
                    RegisterDataState.PasswordRegisterError.InvalidPasswordType -> {
                        stringResource(id = R.string.input_invalid_password)
                    }
                    RegisterDataState.PasswordRegisterError.RepeatPasswordNotCorrect -> {
                        stringResource(id = R.string.input_password_and_repeat_not_correct)
                    }
                    null -> ""
                },
                keyboardType = KeyboardType.Password,
                hint = stringResource(id = R.string.password)
            )
            Spacer(modifier = Modifier.height(SpaseMedium))
            StandartOutlinedTextField(
                text = state.passwordRepeatRegister,
                onValueChange ={
                    viewModel.onEvent(RegisterDataEvent.EnteredRepeatPassword(it))
                },
                error = when(state.passwordRepeatRegisterError){
                    RegisterDataState.PasswordRegisterError.FieldEmpty -> {
                        stringResource(id = R.string.this_field_cant_be_empty)
                    }
                    RegisterDataState.PasswordRegisterError.InputTooShort -> {
                        stringResource(id = R.string.input_too_short_password)
                    }
                    RegisterDataState.PasswordRegisterError.InvalidPasswordBase -> {
                        stringResource(id = R.string.input_invalid_password)
                    }
                    RegisterDataState.PasswordRegisterError.InvalidPasswordType -> {
                        stringResource(id = R.string.input_invalid_password)
                    }
                    RegisterDataState.PasswordRegisterError.RepeatPasswordNotCorrect -> {
                        stringResource(id = R.string.input_password_and_repeat_not_correct)
                    }
                    null -> ""
                },
                keyboardType = KeyboardType.Password,
                hint = stringResource(id = R.string.passwordRepeat)
            )
            Spacer(modifier = Modifier.height(SpaseMedium))
            Text(
                text = stringResource(id = R.string.go_back),
                style = MaterialTheme.typography.h2,
                modifier = Modifier.align(Start)
            )
            Spacer(modifier = Modifier.height(SpaseMedium))
            Button(onClick = {
                viewModel.onEvent(RegisterDataEvent.Register)
                if(viewModel.state.value.passwordRegisterError == null
                    && viewModel.state.value.passwordRepeatRegisterError == null
                    && viewModel.state.value.userEmailError == null
                    && !viewModel.state.value.is_Loading
                ){
                    navController.navigate(BottomNavItem.DiarFragmentScreen.route)
                }
            },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Components)
            ) {
                Text(
                    text = stringResource(id = R.string.sign_up),
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.h1
                )
            }
        }
    }
}


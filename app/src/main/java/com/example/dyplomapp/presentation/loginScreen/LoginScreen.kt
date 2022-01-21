package com.example.dyplomapp.presentation.loginScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dyplomapp.presentation.theme.SpaseMegaLarge
import com.example.dyplomapp.R
import com.example.dyplomapp.data.BottomNavItem
import com.example.dyplomapp.presentation.components.StandartOutlinedTextField
import com.example.dyplomapp.presentation.register_screen.RegisterEvent
import com.example.dyplomapp.presentation.theme.Components
import com.example.dyplomapp.presentation.theme.SpaseLarge
import com.example.dyplomapp.presentation.theme.SpaseMedium
import com.example.dyplomapp.util.Screens

@Composable
fun loginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
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
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp, 0.dp, 25.dp, 0.dp),
        ) {
            Spacer(modifier = Modifier.height(SpaseMegaLarge))
            Text(
                text = stringResource(id = R.string.login_title),
                style = MaterialTheme.typography.h3,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(SpaseMegaLarge*2))
            StandartOutlinedTextField(
                text = state.userLogin,
                onValueChange = {
                    viewModel.onEvent(LoginEvent.EnteredLogin(it))
                },
                error = when(state.userLoginError){
                    LoginState.UserLoginError.FieldEmpty ->{
                        stringResource(id = R.string.this_field_cant_be_empty)
                    }
                    LoginState.UserLoginError.InputTooShort ->{
                        stringResource(id = R.string.input_too_short_login)
                    }
                    null -> ""
                    LoginState.UserLoginError.InvalidLoginBase -> TODO()
                },
                keyboardType = KeyboardType.Text,
                hint = stringResource(id = R.string.login)
            )
            Spacer(modifier = Modifier.height(SpaseMedium))
            StandartOutlinedTextField(
                text = state.passwordLogin,
                onValueChange = {
                    viewModel.onEvent(LoginEvent.EntedPassword(it))
                },
                error = when(state.passwordLoginError){
                    LoginState.PasswordLoginError.FieldEmpty -> {
                        stringResource(id = R.string.this_field_cant_be_empty)
                    }
                    LoginState.PasswordLoginError.InputTooShort -> {
                        stringResource(id = R.string.input_too_short_password)
                    }
                    LoginState.PasswordLoginError.InvalidPasswordBase ->{
                        stringResource(id = R.string.input_invalid_password)
                    }
                    LoginState.PasswordLoginError.InvalidPasswordType ->{
                        stringResource(id = R.string.input_invalid_password)
                    }
                    null -> ""
                },
                keyboardType = KeyboardType.Password,
                hint = stringResource(id = R.string.password)
            )
            Spacer(modifier = Modifier.height(SpaseMedium))
            Text(
                text = stringResource(id = R.string.forgot_password),
                style = MaterialTheme.typography.h2,
                modifier = Modifier.align(Alignment.End)
            )
            Spacer(modifier = Modifier.height(SpaseMedium))
            Button(
                onClick = {
                    //TODO
                    viewModel.onEvent(LoginEvent.Login)
                    if (viewModel.state.value.userLoginError == null && viewModel.state.value.passwordLoginError == null) {
                        navController.navigate(BottomNavItem.DiarFragmentScreen.route)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Components)
            ) {
                Text(
                    text = stringResource(id = R.string.loginButton),
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.h1
                )
            }
            Spacer(modifier = Modifier.height(SpaseMedium))
            Text(
                text = stringResource(id = R.string.back_register),
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .align(Alignment.Start)
                    .clickable {
                        navController.popBackStack()
                        navController.navigate(Screens.RegisterScreen.route)
                    }
            )
        }
    }
}
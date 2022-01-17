package com.example.dyplomapp.presentation.register_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dyplomapp.R
import com.example.dyplomapp.presentation.components.StandartOutlinedTextField
import com.example.dyplomapp.presentation.theme.*
import com.example.dyplomapp.util.Screens

@Composable
fun registerScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
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
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp, 0.dp, 25.dp, 0.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = SpaseMegaLarge),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.register),
                    style = MaterialTheme.typography.h3,
                    textAlign = TextAlign.Center,
                )
            }
            Spacer(modifier = Modifier.height(SpaseMegaLarge*4))
            StandartOutlinedTextField(
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredInviteCode(it))
                },
                text = state.userInviteCode,
                modifier = Modifier.fillMaxWidth(),
                hint = stringResource(id = R.string.code),
                error = when(state.userInviteCodeError){
                    RegisterState.UserInviteCodeError.FieldEmpty -> {
                        stringResource(id = R.string.this_field_cant_be_empty)
                    }
                    RegisterState.UserInviteCodeError.InvalidCode -> {
                        stringResource(id = R.string.input_invalid_code)
                    }
                    RegisterState.UserInviteCodeError.InputTooShor -> {
                        stringResource(id = R.string.input_too_short_code)
                    }
                    null -> ""
                },
                keyboardType = KeyboardType.Text
            )
            Spacer(modifier = Modifier.height(SpaseMedium))
            Button(
                onClick = {
                //TODO
                    viewModel.onEvent(RegisterEvent.Register)
                    if (viewModel.state.value.userInviteCodeError == null) {
                        navController.navigate(Screens.MainScreen.route)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.End),
                colors = ButtonDefaults.buttonColors(backgroundColor = Components)
            ) {
                Text(
                    text = stringResource(id = R.string.registerButton),
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.h1
                )
            }
            Spacer(modifier = Modifier.height(SpaseMedium))
            Text(
                text = stringResource(id = R.string.hint_register),
                style = MaterialTheme.typography.h2,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(SpaseLarge))
            Text(
                text = stringResource(id = R.string.already_have_an_account),
                style = MaterialTheme.typography.h4,
                modifier = Modifier.align(Alignment.End)
                    .clickable {
                        navController.popBackStack()
                        navController.navigate(Screens.LoginScreen.route)
                    }
            )
        }
    }
}
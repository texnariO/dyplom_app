package com.example.dyplomapp.presentation.register_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dyplomapp.presentation.theme.SpaseLarge
import com.example.dyplomapp.R
import com.example.dyplomapp.presentation.components.StandartOutlinedTextField
import com.example.dyplomapp.presentation.theme.SpaseMegaLarge

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
            Spacer(modifier = Modifier.height(SpaseMegaLarge))
            Spacer(modifier = Modifier.height(SpaseMegaLarge))
/*            StandartOutLinedTextField(
                text = state.userInviteCode,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredInviteCode(it))
                },
                error = when(state.userInviteCodeError){
                    RegisterState.UserInviteCodeError.FieldEmpty ->{
                        stringResource(id = R.string.this_field_cant_be_empty)
                    }
                    RegisterState.UserInviteCodeError.InvalidCode ->{
                        stringResource(id = R.string.input_invalid_code)
                    }
                    RegisterState.UserInviteCodeError.InputTooShor ->{
                        stringResource(id = R.string.input_too_short_code)
                    }
                    null -> ""
                },
                keyboardType = KeyboardType.Text,
                hint = stringResource(id = R.string.code)
            )*/
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
                }
            )
        }
    }
}
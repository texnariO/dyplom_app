package com.example.dyplomapp.util

object Constants {
    const val  MIN_CODE_LENGTH = 8
    const val  MAX_CODE_LENGTH = 15

    const val MIN_LOGIN_LENGTH = 4


    const val API_VERSION = "/v1"
    const val USERS = "$API_VERSION/users"
    const val REGISTER_REQUEST = "$USERS/register"
    const val LOGIN_REQUEST = "$USERS/login"
    const val INVITE_CODE_REQUEST = "$USERS/invitecode"
}
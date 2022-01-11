package com.example.dyplomapp.util

sealed class Resourcess<T>(
    val data: T? = null,
    val message: String? = null
){
    class Success<T>(
        data: T
    ): Resourcess<T>(data)

    class Error<T>(
        message: String?,
        data: T?=null
    ): Resourcess<T>(data,message)
}

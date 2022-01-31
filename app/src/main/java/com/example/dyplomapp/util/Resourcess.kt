package com.example.dyplomapp.util

sealed class Resourses<T>(
    val data: T? = null,
    val message: String? = null
){
    class Success<T>(
        data: T
    ): Resourses<T>(data)

    class Error<T>(
        message: String?,
        data: T?=null
    ): Resourses<T>(data,message)
}

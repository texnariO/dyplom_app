package com.example.dyplomapp.data

data class ShortMessItem(
    val nameUser: String,
    val timeMess: String,
    val lastMess: String,
    val messRead: Boolean,
    val image: String? = null
)
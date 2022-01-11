package com.example.dyplomapp.data

import com.example.dyplomapp.R

data class onBoardingItem(
    val image: Int,
    val title: Int,
    val desc: Int
)

val onBoardItems = listOf(
    //TODO Замінити ic.logo на картінки
    onBoardingItem(
        R.mipmap.ic_launcher_logo,
        R.string.first_board_title,
        R.string.first_board_desc
    ),
    //TODO Change
    onBoardingItem(
        R.mipmap.ic_launcher_logo,
        R.string.second_board_title,
        R.string.second_board_desc
    ),
    onBoardingItem(
        R.mipmap.ic_launcher_logo,
        R.string.last_board_title,
        R.string.last_board_desc
    )
)

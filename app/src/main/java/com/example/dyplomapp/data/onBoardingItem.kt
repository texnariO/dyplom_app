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
        R.drawable.ic_logo_image_ed,
        R.string.first_board_title,
        R.string.first_board_desc
    ),
    //TODO Change
    onBoardingItem(
        R.drawable.ic_logo_image_ed,
        R.string.second_board_title,
        R.string.second_board_desc
    ),
    onBoardingItem(
        R.drawable.ic_logo_image_ed,
        R.string.last_board_title,
        R.string.last_board_desc
    )
)

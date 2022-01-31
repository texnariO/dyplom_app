package com.example.dyplomapp.presentation.hight_level_screen.main_screen.fragments.diary

sealed class DiaryEvent {
    data class changeDay(var index: Int) : DiaryEvent()
}
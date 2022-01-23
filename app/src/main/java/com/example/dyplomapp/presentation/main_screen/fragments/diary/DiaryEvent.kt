package com.example.dyplomapp.presentation.main_screen.fragments.diary

sealed class DiaryEvent {
    data class changeDay(var index: Int) : DiaryEvent()
}
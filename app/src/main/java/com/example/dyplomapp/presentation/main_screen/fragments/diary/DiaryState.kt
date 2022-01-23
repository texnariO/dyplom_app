package com.example.dyplomapp.presentation.main_screen.fragments.diary

import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class DiaryState(

    var indexStartDay: Int  = LocalDate.now().format(DateTimeFormatter.ofPattern("c")).toInt(),
    var indexDay: Int = if(indexStartDay == 1 || indexStartDay == 6){
        0
    }
    else {
        indexStartDay - 1
    },
    var number: Int = 0,
    var mounth: String = ""
)

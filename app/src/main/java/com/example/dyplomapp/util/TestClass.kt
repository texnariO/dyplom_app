package com.example.dyplomapp.util

import androidx.compose.ui.res.stringResource
import com.example.dyplomapp.R
import com.example.dyplomapp.data.LectureItem
import com.example.dyplomapp.data.ShortMessItem

val listLessons = listOf(
    LectureItem(
        lesson = "Mathematics",
        homeWork = "§ 34, № 257, № 261",
        startLesson = "09:00",
        endLesson = "09:40",
        clas = "cabinet 7"
    ),
    LectureItem(
        lesson = "Polish Language",
        homeWork = "§ 17 task 15",
        startLesson = "09:55",
        endLesson = "10:35",
        clas = "cabinet 14"
    ),
    LectureItem(
        lesson = "Literature",
        homeWork = "read p.125 - 135",
        startLesson = "10:45",
        endLesson = "11:30",
        clas = "cabinet 14"
    ),
    LectureItem(
        lesson = "Natural Sciences",
        homeWork = "task 3c, read p. 96",
        startLesson = "11:40",
        endLesson = "12:20",
        clas = "cabinet 1"
    ),
    LectureItem(
        lesson = "Chemistry",
        homeWork = "§ 12",
        startLesson = "12:30",
        endLesson = "13:10",
        clas = "cabinet 10"
    )
)

val listDays = listOf(
    R.string.monday,
    R.string.tuesday,
    R.string.wednesday,
    R.string.thursday,
    R.string.friday,
)

val listMessItem = listOf(
    ShortMessItem(
        "Name First",
        "19:00",
        "Hello last message test",
        true
    ),
    ShortMessItem(
        "Name Secondary",
        "21:00",
        "Hello last message test",
        false
    )

)
package com.example.dyplomapp.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.dyplomapp.R

sealed class Screens(val route: String){
    object SpalshScreen: Screens("splash_screen")
    object OnBoardingScreen: Screens("on_boarding_screen")
    object RegisterScreen: Screens("register_screen")
    object LoginScreen: Screens("login_screen")
    //object MainScreen: Screens("main_screen")
    object NoteScreen: Screens("note_screen")
    object ReminderScreen: Screens("reminder_screen")
    object MyClassmateScreen: Screens("classmate_screen")
    object TimetableScreen: Screens("timetable_screen")
    object MarksScreen: Screens("marks_screen")
    object Settings: Screens("settings")
}

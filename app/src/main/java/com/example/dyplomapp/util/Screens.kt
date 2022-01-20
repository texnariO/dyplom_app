package com.example.dyplomapp.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.InsertInvitation
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.dyplomapp.R

sealed class Screens(val route: String){
    object SpalshScreen: Screens("splash_screen")
    object OnBoardingScreen: Screens("on_boarding_screen")
    object RegisterScreen: Screens("register_screen")
    object LoginScreen: Screens("login_screen")
    object MainScreen: Screens("main_screen")
}

sealed class ScreensFragment(
    val id: String,
    val title: String,
    val icon: ImageVector
){
    object Home: ScreensFragment("Diary", R.string.diary.toString(), Icons.Outlined.Book)
    object Calendar: ScreensFragment("Calendar",R.string.calendar.toString(), Icons.Outlined.InsertInvitation)
    object Message: ScreensFragment("Messager",R.string.messager.toString(),Icons.Outlined.Message)
    object Profile: ScreensFragment("Profile",R.string.profile.toString(),Icons.Outlined.Person)

    object Items {
        val list = listOf(
            Home,Calendar,Message,Profile
        )
    }
}
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
}

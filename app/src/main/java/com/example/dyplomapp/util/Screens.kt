package com.example.dyplomapp.util

sealed class Screens(val route: String){
    object SpalshScreen: Screens("splash_screen")
    object OnBoardingScreen: Screens("on_boarding_screen")
}

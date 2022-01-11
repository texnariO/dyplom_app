package com.example.dyplomapp.util

import com.example.dyplomapp.presentation.onBoarding_screen.onBoardingScreen
import com.example.dyplomapp.presentation.splash_screen.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.SpalshScreen.route
    ){
        composable(Screens.SpalshScreen.route){
            SplashScreen(navController = navController)
        }
        composable(Screens.OnBoardingScreen.route){
            onBoardingScreen(navController = navController)
        }
    }

}
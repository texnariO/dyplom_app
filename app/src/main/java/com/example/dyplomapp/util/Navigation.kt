package com.example.dyplomapp.util

import com.example.dyplomapp.presentation.onBoarding_screen.onBoardingScreen
import com.example.dyplomapp.presentation.splash_screen.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dyplomapp.presentation.loginScreen.loginScreen
import com.example.dyplomapp.presentation.main_screen.mainScreen
import com.example.dyplomapp.presentation.register_screen.registerScreen
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
        composable(Screens.RegisterScreen.route){
            registerScreen(navController = navController)
        }
        composable(Screens.MainScreen.route){
            mainScreen(navController = navController)
        }
        composable(Screens.LoginScreen.route){
            loginScreen(navController = navController)
        }
    }

}
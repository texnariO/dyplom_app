package com.example.dyplomapp.util

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import com.example.dyplomapp.presentation.onBoarding_screen.onBoardingScreen
import com.example.dyplomapp.presentation.splash_screen.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dyplomapp.data.BottomNavItem
import com.example.dyplomapp.presentation.classmate_screen.ClassmateScreen
import com.example.dyplomapp.presentation.loginScreen.loginScreen
import com.example.dyplomapp.presentation.main_screen.fragments.calendar.calendarScreen
import com.example.dyplomapp.presentation.main_screen.fragments.diary.diaryScreen
import com.example.dyplomapp.presentation.main_screen.fragments.message.messageScreen
import com.example.dyplomapp.presentation.main_screen.fragments.profile.profileScreen
import com.example.dyplomapp.presentation.marks_screen.MarksScreen
import com.example.dyplomapp.presentation.note_and_reminder_screen.NoteScreen
import com.example.dyplomapp.presentation.note_and_reminder_screen.ReminderScreen
import com.example.dyplomapp.presentation.register_screen.registerScreen
import com.example.dyplomapp.presentation.settings_screen.SettingsScreen
import com.example.dyplomapp.presentation.timetable_screen.TimetableScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
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
        composable(Screens.LoginScreen.route){
            loginScreen(navController = navController)
        }
        composable(Screens.NoteScreen.route){
            NoteScreen(navController = navController)
        }
        composable(Screens.ReminderScreen.route){
            ReminderScreen(navController = navController)
        }
        composable(Screens.MyClassmateScreen.route){
            ClassmateScreen(navController = navController)
        }
        composable(Screens.TimetableScreen.route){
            TimetableScreen(navController = navController)
        }
        composable(Screens.MarksScreen.route){
            MarksScreen(navController = navController)
        }
        composable(Screens.Settings.route){
            SettingsScreen(navController = navController)
        }
        composable(BottomNavItem.DiarFragmentScreen.route){
            diaryScreen(navController = navController)
        }
        composable(BottomNavItem.CalendarFragmentScreen.route){
            calendarScreen(navController = navController)
        }
        composable(BottomNavItem.MessageFragmentScreen.route){
            messageScreen(navController = navController)
        }
        composable(BottomNavItem.ProfileFragmentScreen.route){
            profileScreen(navController = navController)
        }
    }

}
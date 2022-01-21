package com.example.dyplomapp.presentation.main_screen.fragments.diary

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.dyplomapp.data.bottomNavItems
import com.example.dyplomapp.presentation.components.StandartBottomNavigationBar
import com.example.dyplomapp.presentation.main_screen.BottomNavigationBar

@ExperimentalAnimationApi
@Composable
fun diaryScreen(
    navController: NavController
) {
    Scaffold(
        bottomBar = {
            StandartBottomNavigationBar(
                items = bottomNavItems,
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }
    ) {
        Text(text = "Text")
    }
}
package com.example.dyplomapp.presentation.main_screen.fragments.message

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.dyplomapp.data.bottomNavItems
import com.example.dyplomapp.presentation.components.StandartBottomNavigationBar

@ExperimentalAnimationApi
@Composable
fun messageScreen(
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
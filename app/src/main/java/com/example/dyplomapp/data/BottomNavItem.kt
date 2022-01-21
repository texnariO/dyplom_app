package com.example.dyplomapp.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.InsertInvitation
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.dyplomapp.R

sealed class BottomNavItem(
    val name: Int,
    val route: String,
    val icon: ImageVector
){
    object DiarFragmentScreen: BottomNavItem(
        R.string.diary,
        "diary",
        Icons.Outlined.Book
    )
    object CalendarFragmentScreen: BottomNavItem(
        R.string.calendar,
        "calendar",
        Icons.Outlined.InsertInvitation
    )
    object MessageFragmentScreen: BottomNavItem(
        R.string.messager,
        "messager",
        Icons.Outlined.ChatBubbleOutline
    )
    object ProfileFragmentScreen: BottomNavItem(
        R.string.profile,
        "profile",
        Icons.Outlined.Person
    )
}

val bottomNavItems = listOf(
    BottomNavItem.DiarFragmentScreen,
    BottomNavItem.CalendarFragmentScreen,
    BottomNavItem.MessageFragmentScreen,
    BottomNavItem.ProfileFragmentScreen
)

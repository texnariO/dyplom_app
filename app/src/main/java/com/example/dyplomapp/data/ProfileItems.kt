package com.example.dyplomapp.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.dyplomapp.R
import com.example.dyplomapp.util.Screens

data class ProfileItems(
    val image: ImageVector,
    val name: Int,
    val route: String
)

val listProfileItem = listOf(
    ProfileItems(
        Icons.Outlined.Group,
        R.string.my_classmate,
        Screens.MyClassmateScreen.route
    ),
    ProfileItems(
        Icons.Outlined.DateRange,
        R.string.timetable_of_classes,
        Screens.TimetableScreen.route
    ),
    ProfileItems(
        Icons.Outlined.TrendingUp,
        R.string.marks_and_avg,
        Screens.MarksScreen.route
    ),
    ProfileItems(
        Icons.Outlined.Settings,
        R.string.settings,
        Screens.Settings.route
    ),
    ProfileItems(
        Icons.Outlined.Logout,
        R.string.log_out,
        Screens.LoginScreen.route
    )
)
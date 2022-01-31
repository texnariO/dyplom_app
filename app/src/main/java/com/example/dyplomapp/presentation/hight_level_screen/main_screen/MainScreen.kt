package com.example.dyplomapp.presentation.hight_level_screen.main_screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.dyplomapp.data.BottomNavItem
import com.example.dyplomapp.data.bottomNavItems
import com.example.dyplomapp.presentation.theme.Components
import com.example.dyplomapp.presentation.theme.Secondary


@ExperimentalAnimationApi
@Composable
fun mainScreen(
    navController: NavController
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = bottomNavItems,
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }
    ) {

    }
}

@ExperimentalAnimationApi
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Secondary,
        elevation = 5.dp
    ) {
        items.forEach {
            item->
            val selected = item.route == backStackEntry.value?.destination?.route
            val contentColor = if(selected) Components else MaterialTheme.colors.onBackground
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = contentColor,
                unselectedContentColor = MaterialTheme.colors.onBackground,
                icon = {
                    Row(
                        modifier = Modifier
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ){
                        Icon(
                            imageVector = item.icon,
                            contentDescription = null,
                            tint = contentColor
                        )
                        AnimatedVisibility(
                            visible = selected
                        ) {
                            Text(
                                text = stringResource(id = item.name)
                            )
                        }
                    }
                }
            )
        }
    }
}


package com.example.dyplomapp.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.dyplomapp.data.BottomNavItem
import com.example.dyplomapp.presentation.theme.Components
import com.example.dyplomapp.presentation.theme.Secondary

@ExperimentalAnimationApi
@Composable
fun StandartBottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit,
    cutoutShape: CornerBasedShape
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomAppBar(
        modifier = modifier,
        backgroundColor = Secondary,
        elevation = 5.dp,
        cutoutShape = cutoutShape
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
                    Column(
                        horizontalAlignment = CenterHorizontally
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
                                text = stringResource(id = item.name),
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            )
        }
    }
}
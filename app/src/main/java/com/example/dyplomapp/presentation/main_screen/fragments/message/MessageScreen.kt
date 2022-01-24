package com.example.dyplomapp.presentation.main_screen.fragments.message

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dyplomapp.R
import com.example.dyplomapp.data.bottomNavItems
import com.example.dyplomapp.presentation.components.ShortInfoMessage
import com.example.dyplomapp.presentation.components.StandartBottomNavigationBar
import com.example.dyplomapp.presentation.theme.Components
import com.example.dyplomapp.util.Screens
import com.example.dyplomapp.util.listMessItem
import com.google.accompanist.pager.rememberPagerState

@ExperimentalAnimationApi
@Composable
fun messageScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(

                        text = stringResource(id = R.string.messager),
                        style = MaterialTheme.typography.h1,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                backgroundColor = Components
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            StandartBottomNavigationBar(
                items = bottomNavItems,
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                },
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                )
            )
        }
    ) {
        var expandeds by remember { mutableStateOf(false) }
        BoxWithConstraints(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            DropdownMenu(
                expanded = expandeds,
                onDismissRequest = { expandeds = false },
                offset = DpOffset(maxWidth*0.33f,maxHeight*0.66f)
                /*modifier = Modifier.align(Alignment.CenterHorizontally)*/

            ) {
                DropdownMenuItem(onClick = { navController.navigate(Screens.NoteScreen.route) }) {
                    Text(stringResource(id = R.string.note))
                }
                Divider()
                DropdownMenuItem(onClick = {  navController.navigate(Screens.ReminderScreen.route)}) {
                    Text(stringResource(id = R.string.reminder))
                }
            }
        }
        val scroll = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scroll)
                .padding(start = 10.dp, end = 10.dp, bottom = 100.dp)
        ) {
            listMessItem.forEach {
                ShortInfoMessage(messItem = it)
            }
        }
    }
}

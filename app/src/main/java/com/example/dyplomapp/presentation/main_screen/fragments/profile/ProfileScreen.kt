package com.example.dyplomapp.presentation.main_screen.fragments.profile

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.CalendarViewMonth
import androidx.compose.material.icons.outlined.Group
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.dyplomapp.data.bottomNavItems
import com.example.dyplomapp.presentation.components.StandartBottomNavigationBar
import com.example.dyplomapp.presentation.theme.Components
import com.example.dyplomapp.R
import com.example.dyplomapp.data.UserShortInfo
import com.example.dyplomapp.data.listProfileItem
import com.example.dyplomapp.presentation.components.ShortInfoProfileUser
import com.example.dyplomapp.presentation.theme.SecondaryGray
import com.example.dyplomapp.util.Screens

@ExperimentalAnimationApi
@Composable
fun profileScreen(
    navController: NavController
) {
    var expandeds by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.profile),
                        style = MaterialTheme.typography.h1,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {  expandeds = !expandeds },
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
        val scrolState = rememberScrollState()
        Column(modifier = Modifier.fillMaxSize()) {
            ShortInfoProfileUser(userInfo = UserShortInfo("Full Name","class 10 - A","Information about school"))
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 50.dp)
                    .fillMaxSize()
                    .verticalScroll(scrolState)
            ){
                listProfileItem.forEach {profile ->
                    Row(modifier = Modifier.fillMaxWidth()
                        .padding(top = 20.dp , bottom =  20.dp)
                        .clickable {
                            navController.navigate(profile.route)
                        }) {
                        Icon(
                            imageVector = profile.image,
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.padding(end = 30.dp)
                        )
                        Text(text = stringResource(id = profile.name),fontSize = 17.sp)
                    }
                }
            }
        }

    }
}


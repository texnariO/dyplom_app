package com.example.dyplomapp.presentation.main_screen.fragments.diary

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dyplomapp.R
import com.example.dyplomapp.data.bottomNavItems
import com.example.dyplomapp.presentation.components.LessonsScheduleItem
import com.example.dyplomapp.presentation.components.StandartBottomNavigationBar
import com.example.dyplomapp.presentation.theme.Components
import com.example.dyplomapp.presentation.theme.Secondary
import com.example.dyplomapp.util.Screens
import com.example.dyplomapp.util.listDays
import com.example.dyplomapp.util.listLessons
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter.ofPattern
import androidx.compose.material.Text as Text

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun diaryScreen(
    navController: NavController,
    viewModel: DiaryViewModel = hiltViewModel()
) {
    var expandeds by remember { mutableStateOf(false)}
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.diary),
                        style = MaterialTheme.typography.h1,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    expandeds = !expandeds
                },
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

        //  viewModel.state.value.number = LocalDate.now().format(ofPattern("d")).toInt()
        //  viewModel.state.value.mounth = LocalDate.now().format(ofPattern("MMMM"))

        val pagerState = rememberPagerState()
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            NavigateTabs(viewModel,pagerState)
            NavigateTabsContent(viewModel,pagerState)

        }
    }
}


@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun NavigateTabs(viewModel: DiaryViewModel,pagerState: PagerState) {
    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = viewModel.state.value.indexDay,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        listDays.forEachIndexed { index, tab ->
            Tab(
                selected = index == viewModel.state.value.indexDay-1,
                onClick = {
                          scope.launch {
                              viewModel.onEvent(DiaryEvent.changeDay(index))
                              pagerState.animateScrollToPage(index)

                          }
                },
                text = { Text(text = stringResource(id = tab))},
                modifier = Modifier
                    .background(
                        if (index == viewModel.state.value.indexDay)
                            Components
                        else
                            Secondary
                    )
                    .padding(start = 5.dp, end = 5.dp)
                ,
                unselectedContentColor = Secondary,
            )
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun NavigateTabsContent(viewModel: DiaryViewModel,pagerState: PagerState) {
    HorizontalPager(
        count = listDays.size,
        state = pagerState
    ) {page ->
        NavigateRow(viewModel = viewModel)
    }
}
@ExperimentalFoundationApi
@Composable
fun NavigateRow(
    viewModel: DiaryViewModel
) {
    val scrolState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 100.dp)
            .fillMaxSize()
            .verticalScroll(scrolState),
     //  cells = GridCells.Fixed(1)
    ) {
        //val nameDay = checkDay(viewModel.state.value.indexDay)
        //TODO Розширити
       /* Text(text = "$nameDay, ${viewModel.state.value.mounth} ")*/
            listLessons.forEachIndexed {
                    index, lectureItem ->
                LessonsScheduleItem(lectureItem = lectureItem, number = index+1,
                    thisLast = index == listLessons.size-1, thisActive = index != 0
                )
            }
        }
    }
/*
@Composable
fun checkDay(page: Int): String {
    when(page){
        0 -> {
            return stringResource(id = R.string.monday_full)
        }
        1 -> {
            return  stringResource(id = R.string.tuesday_full)
        }
        2 ->{
            return  stringResource(id = R.string.wednesday_full)
        }
        3 ->{
            return stringResource(id = R.string.thursday_full)
        }
        4 ->{
            return stringResource(id = R.string.friday_full)
        }
    }
    return ""
}*/

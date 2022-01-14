package com.example.dyplomapp.presentation.onBoarding_screen

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.dyplomapp.R
import com.example.dyplomapp.data.onBoardItems
import com.example.dyplomapp.data.onBoardingItem
import com.example.dyplomapp.presentation.theme.*
import com.example.dyplomapp.util.Screens
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun onBoardingScreen(
    navController: NavController,
) {
    val scope = rememberCoroutineScope()
    Column(Modifier.fillMaxSize()) {
       TopSection(navController)

        val items = onBoardItems
        val state = rememberPagerState(pageCount = items.size)
        HorizontalPager(
            state = state,
            modifier = Modifier
                .fillMaxSize()
                .weight(0.8f)
        ) {
            page -> OnBoardingItem(items[page])

        }
        BottomSection(
            size = 3,
            index = state.currentPage,
        ) {
            if(state.currentPage+1 < items.size)
                scope.launch {
                    state.scrollToPage(state.currentPage)
                }
        }
    }

}

@Composable
fun OnBoardingItem(
    item: onBoardingItem
) {
    //TODO
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(0.5f)
            //modifier = Modifier.scale(12f)
        )
        Spacer(modifier = Modifier.height(SpaseMedium))
        Text(
            text = stringResource(id = item.title ),
            style = MaterialTheme.typography.body1,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(SpaseMedium))
        Text(
            text =  stringResource(id = item.desc),
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun TopSection(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(SpaseMedium)
    ){
        IconButton(
            onClick = { },
            modifier = Modifier
                .align(Alignment.CenterStart)
        ) {
            Icon(Icons.Outlined.KeyboardArrowLeft, contentDescription = null)
        }

        TextButton(
            onClick = {
                      navController.popBackStack()
                navController.navigate(Screens.RegisterScreen.route)
            },
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Text(text = stringResource(id = R.string.skip_on_board),color = MaterialTheme.colors.onBackground)
        }
    }
}

@Composable
fun BottomSection(
    size: Int,
    index: Int,
    onNextClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(SpaseMedium)
    ){
        Indicators(size = size, index = index)
        FloatingActionButton(
            onClick = onNextClicked,
            modifier = Modifier.align(Alignment.CenterEnd),
            backgroundColor = Components,
            contentColor = MaterialTheme.colors.onPrimary
        ) {
            Icon(imageVector = Icons.Outlined.KeyboardArrowRight, contentDescription = null)
        }
    }
}

@Composable
fun BoxScope.Indicators(size: Int, index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.align(Alignment.CenterStart)
    ) {
        repeat(size){
            Indicator(isSelected = it==index)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(
        targetValue = if(isSelected) 25.dp else 10.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )
    Box(
        modifier = Modifier
            .height(SpaseSmall)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) Components
                else SecondaryGray
            )
    ){

    }
}
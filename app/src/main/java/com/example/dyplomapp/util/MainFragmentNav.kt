package com.example.dyplomapp.util

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.dyplomapp.presentation.theme.Components

@Composable
fun FragmentNavigation(
    currentScreenId: String,
    onItemSelected: (ScreensFragment)->Unit
) {

}

@Composable
fun FragmentNavigationItem(item: ScreensFragment,isSelected:Boolean,onClick:()->Unit) {
    val background = if (isSelected) Components.copy(0.1f) else Color.Transparent
    val contentColor = if (isSelected) Components else MaterialTheme.colors.onBackground
    Box(
        modifier = Modifier.clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick)
    ){

    }
}
@Preview
@Composable
fun Preview() {
    FragmentNavigation(currentScreenId = ScreensFragment.Home.id){

    }
}
@Preview
@Composable
fun Preview2() {
    FragmentNavigationItem(item = ScreensFragment.Home, isSelected = true) {

    }
}
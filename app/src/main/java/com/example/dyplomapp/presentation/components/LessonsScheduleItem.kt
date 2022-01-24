package com.example.dyplomapp.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dyplomapp.data.LectureItem
import com.example.dyplomapp.presentation.theme.Components
import com.example.dyplomapp.presentation.theme.Secondary
import com.example.dyplomapp.presentation.theme.SecondaryNotActive
import com.example.dyplomapp.presentation.theme.SpaseLarge
import com.example.dyplomapp.util.listLessons

@ExperimentalFoundationApi
@Composable
fun LessonsScheduleItem(
    thisLast: Boolean = false,
    thisActive: Boolean = true,
    lectureItem: LectureItem,
    number: Int,
) {
    val color = if(thisActive) Color.Black else Color.Gray
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Min)) {
        Column(
            modifier = Modifier.padding(end = 20.dp)
        ) {
            Text(
                text = number.toString(),
                style = MaterialTheme.typography.h5,
                color = color,
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(if (thisActive) Components else Secondary)
                    .padding(10.dp, 5.dp)
            )
            if(!thisLast) {
                Divider(
                    color = if (thisActive) Components else Secondary,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .weight(1f)
                        .width(4.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 10.dp)
                .background(if (!thisActive) Secondary else SecondaryNotActive)

        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 10.dp)) {
                Text(
                    text = lectureItem.lesson,
                    modifier = Modifier.align(Alignment.TopStart),
                    color = color,
                    style = MaterialTheme.typography.h5
                )
                Text(
                    text = lectureItem.clas,
                    modifier = Modifier.align(Alignment.BottomEnd),
                    color = color,
                    style = MaterialTheme.typography.h5
                )
                Spacer(modifier = Modifier.height(SpaseLarge*3))
                Text(
                    text = buildAnnotatedString{
                        append(lectureItem.startLesson)
                        append(" - ")
                        append(lectureItem.endLesson)
                    },
                    modifier = Modifier.align(Alignment.TopEnd),
                    color = color,
                    style = MaterialTheme.typography.h5
                )
                Text(
                    text = lectureItem.homeWork,
                    modifier = Modifier.align(Alignment.BottomStart),
                    color = color,
                    style = MaterialTheme.typography.h5
                )
            }
        }
    }
}


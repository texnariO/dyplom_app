package com.example.dyplomapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dyplomapp.R
import com.example.dyplomapp.presentation.theme.Components
import com.example.dyplomapp.presentation.theme.HintRed
import com.example.dyplomapp.presentation.theme.Secondary
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.unit.sp
import com.example.dyplomapp.data.ShortMessItem
import com.example.dyplomapp.util.listMessItem


@Composable
fun ShortInfoMessage(
    messItem: ShortMessItem
) {
    Row(
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
            .background(Secondary)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_empty_image),
            contentDescription = null,
            modifier = Modifier
                .border(
                    width = 4.dp,
                    color = if (messItem.messRead) Secondary else HintRed,
                    shape = CircleShape
                )
                .padding(3.dp)
                .clip(CircleShape)
                .background(Color.White)
        )
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                    Text(
                        text = messItem.nameUser,
                        style = MaterialTheme.typography.h5,
                        color = Black,
                        modifier = Modifier.align(Alignment.TopStart).padding(top = 10.dp)
                    )
                    Text(
                        text = messItem.timeMess,
                        fontSize = 14.sp,
                        color = Gray,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(top = 10.dp, end = 10.dp)
                    )
                }
            Text(text = messItem.lastMess, fontSize = 18.sp, modifier = Modifier.padding(top= 10.dp))
        }
    }
}



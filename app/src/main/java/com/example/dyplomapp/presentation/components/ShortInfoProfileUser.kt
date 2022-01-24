package com.example.dyplomapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dyplomapp.R
import com.example.dyplomapp.data.UserShortInfo
import com.example.dyplomapp.presentation.theme.Components
import com.example.dyplomapp.presentation.theme.Secondary
import com.example.dyplomapp.presentation.theme.SpaseLarge

@Composable
fun ShortInfoProfileUser(
    userInfo: UserShortInfo
) {
    Box(
      modifier = Modifier
          .padding(10.dp, 25.dp, 10.dp, 10.dp)
          .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 30.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Secondary)
        ){
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)) {

                Spacer(modifier = Modifier.height(SpaseLarge*4))
                Text(
                    text = userInfo.name,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 10.dp),
                    style = MaterialTheme.typography.h4,
                )
                Text(
                    text = userInfo.clas,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 10.dp),
                    style = MaterialTheme.typography.h5,
                    color = Color.Black
                )
                Text(
                    text = userInfo.school,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 10.dp),
                    style = MaterialTheme.typography.h5,
                    fontSize = 15.sp,
                    color = Color.LightGray
                )
            }
        }
        //TODO add download image userInfo.image
        Image(
            painter = painterResource(id = R.drawable.ic_empty_image),
            contentDescription = null,
            modifier = Modifier
                // .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .border(
                    width = 4.dp,
                    color = Components,
                    shape = CircleShape
                )
                .padding(3.dp)
                .clip(CircleShape)
                .background(Color.White)
        )
    }
}


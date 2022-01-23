package com.example.dyplomapp.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.dyplomapp.R

val SegoeUI = FontFamily(
    Font(R.font.segoe_ui,FontWeight.Normal),
    Font(R.font.segoe_ui_bold, FontWeight.Bold),
    Font(R.font.segoe_ui_italic, FontWeight.SemiBold),
    Font(R.font.segoe_ui_bold_italic, FontWeight.Medium)
)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = SegoeUI,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        color = Color.Black
    ),
    h1 = TextStyle(
        fontFamily = SegoeUI,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = Color.Black
    ),
    h2 = TextStyle(
        fontFamily = SegoeUI,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = HintGray
    ),
    body2 = TextStyle(
        fontFamily = SegoeUI,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = HintRed
    ),
    h3 = TextStyle(
        fontFamily = SegoeUI,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = Color.Black
    ),
    h4 = TextStyle(
    fontFamily = SegoeUI,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
    color = Color.Black
    ),
    h5 = TextStyle(
        fontFamily = SegoeUI,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
        color = Color.Black
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
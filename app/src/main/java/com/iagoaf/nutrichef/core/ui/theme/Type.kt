package com.iagoaf.nutrichef.core.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.iagoaf.nutrichef.R


data class AppTypography(
    val heading1: TextStyle,
    val heading2: TextStyle,
    val heading3: TextStyle,
    val subHeading: TextStyle,
    val numberMd: TextStyle,
    val numberSm: TextStyle,
)

val poppingsRegular = FontFamily(
    Font(R.font.poppins_regular)
)


val appTypography = AppTypography(
    heading1 = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = poppingsRegular
    ),
    heading2 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = poppingsRegular
    ),
    heading3 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = poppingsRegular
    ),
    subHeading = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = poppingsRegular
    ),
    numberMd = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = poppingsRegular
    ),
    numberSm = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = poppingsRegular
    )
)

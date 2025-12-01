package com.seenubommisetti.quotes.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.seenubommisetti.quotes.R

val PtSerifFontFamily = FontFamily(
    Font(R.font.pt_serif_regular, FontWeight.Normal),
    Font(R.font.pt_serif_bold, FontWeight.Bold),
    Font(R.font.pt_serif_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.pt_serif_bold_italic, FontWeight.Bold, FontStyle.Italic)
)

val AppTypography = Typography(
    headlineMedium = TextStyle(
        fontFamily = PtSerifFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 24.sp,
    ),

    titleMedium = TextStyle(
        fontFamily = PtSerifFontFamily,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        fontSize = 16.sp
    ),

    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    ),

    titleLarge = TextStyle(
        fontFamily = PtSerifFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
)
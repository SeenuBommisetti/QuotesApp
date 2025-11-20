package com.seenubommisetti.quotes.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SectionHeader(
    startText: String,
    endText: String,
    onNavigate: () -> Unit = { }
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp),
    ) {
        Text(
            text = startText,
            fontSize = 18.sp,
            fontWeight = FontWeight.Black,
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = endText,
            color = Color.Blue,
            modifier = Modifier.clickable(
                onClick = { onNavigate() }
            )
        )
    }
}
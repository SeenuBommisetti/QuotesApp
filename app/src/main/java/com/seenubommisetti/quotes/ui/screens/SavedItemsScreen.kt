package com.seenubommisetti.quotes.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun SavedItemsScreen(modifier: Modifier = Modifier) {

    Box(modifier = modifier.fillMaxSize().background(color = Color.Transparent), contentAlignment = Alignment.Center) {
        Text("No Saved Quotes", fontSize = 18.sp)
    }
}
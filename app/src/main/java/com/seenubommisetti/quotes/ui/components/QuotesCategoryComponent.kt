package com.seenubommisetti.quotes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun QuotesCategoryComponent(
    categoryIcon: ImageVector,
    categoryName: String,
    bgColor: Color = Color.Blue,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(120.dp)
            .height(120.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {},
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(bgColor.copy(alpha = 0.08f))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Surface(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(bgColor.copy(alpha = 0.5f))
            ) {
                Icon(
                    categoryIcon,
                    "",
                    Modifier
                        .size(44.dp)
                        .padding(12.dp),
                    tint = bgColor
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            Text(categoryName, fontWeight = FontWeight.SemiBold)

        }

    }

}

@Preview(showBackground = true)
@Composable
fun CategoryPreview() {
    QuotesCategoryComponent(Icons.Default.Favorite, "Motivation")
}
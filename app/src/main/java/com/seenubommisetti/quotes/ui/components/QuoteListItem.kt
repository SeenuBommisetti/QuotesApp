package com.seenubommisetti.quotes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seenubommisetti.quotes.data.QuoteCategory
import com.seenubommisetti.quotes.data.model.Quote
import com.seenubommisetti.quotes.ui.theme.QuotesTheme

@Composable
fun QuoteListItem(
    quote: Quote,
    modifier: Modifier = Modifier,
    onFavoriteClick: () -> Unit = {},
    isFavorite: Boolean = false,
    isExploreScreen: Boolean = false,
) {

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface),
        shadowElevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            QuoteAvatar(avatar = quote.avatar)

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "— ${quote.author}",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.align(Alignment.End)
                )
            }


            if (!isExploreScreen) {
                Spacer(modifier = Modifier.width(12.dp))

                IconButton(onClick = onFavoriteClick) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = "Save Quote",
                        tint = if (isFavorite) Color.Red.copy(alpha = 0.8f) else Color.White.copy(alpha = 0.8f),
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

        }
    }
}

@Composable
fun QuoteAvatar(avatar: String, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .size(44.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)),
        contentAlignment = Alignment.Center
    ) {
        Text(avatar)
    }
}

@Preview(showBackground = true)
@Composable
fun QuoteListItemPreview() {
    QuotesTheme {
        QuoteListItem(
            quote = Quote(
                17,
                "Innovation distinguishes between a leader and a follower.",
                "Steve Jobs",
                QuoteCategory.LEADERSHIP
            )
        )
    }
}
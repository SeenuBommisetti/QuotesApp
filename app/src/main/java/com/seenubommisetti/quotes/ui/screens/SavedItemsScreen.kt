package com.seenubommisetti.quotes.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seenubommisetti.quotes.data.QuotesDataSource
import com.seenubommisetti.quotes.ui.components.QuoteListItem
import com.seenubommisetti.quotes.ui.theme.QuotesTheme

@Composable
fun SavedItemsScreen(modifier: Modifier = Modifier) {
    val savedList = QuotesDataSource.savedQuotes

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Saved Quotes",
            style = MaterialTheme.typography.headlineMedium.copy(fontSize = 28.sp),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (savedList.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("No saved quotes yet!", style = MaterialTheme.typography.bodyMedium)
            }
        } else {
            LazyColumn {
                items(savedList) { quote ->
                    QuoteListItem(
                        quote = quote,
                        onFavoriteClick = {
                            QuotesDataSource.toggleFavorite(quote)
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SavedItemsScreenPreview() {
    QuotesTheme {
        SavedItemsScreen()
    }
}
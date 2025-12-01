package com.seenubommisetti.quotes.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seenubommisetti.quotes.data.QuoteCategory
import com.seenubommisetti.quotes.data.QuotesDataSource.getAllQuotes
import com.seenubommisetti.quotes.data.model.Quote
import com.seenubommisetti.quotes.ui.components.QuoteListItem
import com.seenubommisetti.quotes.ui.theme.QuotesTheme


@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier,
    categories: List<QuoteCategory> = QuoteCategory.entries,
    quotes: List<Quote> = getAllQuotes(),
    category: String? = null
) {
    var selectedCategoryName by remember { mutableStateOf("All") }

    if(category != null) {
        selectedCategoryName = category
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Explore",
            style = MaterialTheme.typography.headlineMedium.copy(fontSize = 28.sp),
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                FilterChip(
                    selected = selectedCategoryName == "All",
                    onClick = { selectedCategoryName = "All" },
                    label = { Text("All") },
                    shape = RoundedCornerShape(20.dp),
                    colors = if ( selectedCategoryName == "All") FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        selectedLabelColor = MaterialTheme.colorScheme.onPrimary
                    ) else FilterChipDefaults.filterChipColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        labelColor = MaterialTheme.colorScheme.onSurface
                    )
                )
            }
            items(categories) { category ->
                val selected = category.displayName == selectedCategoryName

                FilterChip(
                    selected = selected,
                    onClick = { selectedCategoryName = category.displayName },
                    label = { Text(category.displayName) },
                    shape = RoundedCornerShape(20.dp),
                    colors = if (selected) FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        selectedLabelColor = MaterialTheme.colorScheme.onPrimary
                    ) else FilterChipDefaults.filterChipColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        labelColor = MaterialTheme.colorScheme.onSurface
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        val filtered = if (selectedCategoryName == "All") quotes else quotes.filter { it.category.displayName == selectedCategoryName }


        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(filtered, key = { it.id }) { quote ->
                QuoteListItem(quote = quote, isExploreScreen = true)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ExploreScreenPreview() {
    QuotesTheme {
        ExploreScreen()
    }
}
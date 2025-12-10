package com.seenubommisetti.quotes.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.seenubommisetti.quotes.data.QuoteCategory
import com.seenubommisetti.quotes.ui.QuotesViewModel
import com.seenubommisetti.quotes.ui.components.QuoteItemComponent
import com.seenubommisetti.quotes.ui.components.QuotesCategoryComponent
import com.seenubommisetti.quotes.ui.components.SectionHeader
import com.seenubommisetti.quotes.ui.theme.QuotesTheme


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: QuotesViewModel = viewModel(),
    onNavigateToExplore: () -> Unit = {},
    onNavigateToCategory: (String) -> Unit = {}
) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal =  12.dp)
    ) {
        item {
            Text(
                text = "Quotes",
                style = MaterialTheme.typography.headlineMedium
                    .copy(fontWeight = FontWeight.Bold, fontSize = 28.sp),
            )
            Text(
                text = "Explore awesome quotes from our community",
                style = MaterialTheme.typography.labelLarge,
            )
        }

        item { Spacer(modifier = Modifier.padding(8.dp)) }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .fillMaxHeight(0.25f)
            ) {
                AsyncImage(
                    model = "https://i.pinimg.com/736x/1a/fd/3f/1afd3f3fd73871816c92cf7cdbbd449f.jpg",
                    contentDescription = "Banner Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                )

            }
        }

        item {
            SectionHeader(
                "Latest Quotes",
                "View All",
            ) {
                onNavigateToExplore()
            }
        }

        item {
            QuotesList(viewModel = viewModel)
        }
        item {
            SectionHeader(
                "Categories",
                "View All",
            ) {
                onNavigateToExplore()
            }
        }
        item {
            QuotesCategoryList(
                onNavigateToCategory = onNavigateToCategory
            )
        }

        item {
            SectionHeader(
                "Popular Quotes",
                "View All",
            ) {
                onNavigateToExplore()
            }
        }

        item {
            QuotesList(viewModel = viewModel)
        }
    }
}

@Composable
fun QuotesList(
    viewModel: QuotesViewModel,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxWidth()

    ) {
        items(viewModel.fetchQuotes()) {
            QuoteItemComponent(
                quote = it,
                onFavoriteClick = {
                    viewModel.toggleFavorite(it)
                },
                isFavorite = viewModel.isFavorite(it),
                modifier = modifier
            )
        }
    }
}




@Composable
fun QuotesCategoryList(
    onNavigateToCategory: (String) -> Unit = {}
) {

    LazyRow {
        items(QuoteCategory.entries) { category ->
            QuotesCategoryComponent(
                categoryIcon = category.icon,
                categoryName = category.displayName,
                bgColor = category.bgColor,
                onCategoryClick = onNavigateToCategory
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun QuotesHomeScreenPreview() {
    QuotesTheme {
        HomeScreen()
    }
}
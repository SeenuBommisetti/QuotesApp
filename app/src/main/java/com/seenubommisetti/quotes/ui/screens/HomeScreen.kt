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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.seenubommisetti.quotes.data.QuoteCategory
import com.seenubommisetti.quotes.data.getAllQuotes
import com.seenubommisetti.quotes.data.model.Quote
import com.seenubommisetti.quotes.ui.components.QuoteItemComponent
import com.seenubommisetti.quotes.ui.components.QuotesCategoryComponent
import com.seenubommisetti.quotes.ui.components.SectionHeader

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToExplore: () -> Unit = {},
) {

    LazyColumn(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()
    ) {
        item {
            Text(
                text = "Quotes",
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(top = 12.dp)
            )
            Text(
                text = "Explore awesome quotes from our community",
                fontSize = 16.sp,
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
            QuotesList(quotes = getAllQuotes())
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
            QuotesCategoryList()
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
            QuotesList(quotes = getAllQuotes())
        }
    }

}

@Composable
fun QuotesList(
    quotes: List<Quote>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxWidth()

    ) {
        items(quotes) {
            QuoteItemComponent(quote = it, modifier = modifier)
        }
    }
}


@Composable
fun QuotesCategoryList() {

    LazyRow {
        items(QuoteCategory.entries) { category ->
            QuotesCategoryComponent(
                categoryIcon = category.icon,
                categoryName = category.displayName,
                bgColor = category.bgColor,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun QuotesHomeScreenPreview() {
    HomeScreen()
}
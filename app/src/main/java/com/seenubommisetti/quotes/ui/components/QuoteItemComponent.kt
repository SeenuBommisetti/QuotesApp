package com.seenubommisetti.quotes.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seenubommisetti.quotes.data.QuotesDataSource
import com.seenubommisetti.quotes.data.QuotesDataSource.getAllQuotes
import com.seenubommisetti.quotes.data.model.Quote
import com.seenubommisetti.quotes.ui.theme.QuotesTheme

@Composable
fun QuoteItemComponent(
    quote: Quote,
    modifier: Modifier = Modifier,
    onFavoriteClick: () -> Unit = {}
) {

    val isSaved = QuotesDataSource.isFavorite(quote)

    val bgGradient = Brush.linearGradient(
        colors = listOf(Color(0xFF6A11CB), Color(0xFF2575FC))
    )

    Card(
        modifier = modifier
            .width(250.dp)
            .height(250.dp),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(bgGradient)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.FormatQuote,
                contentDescription = null,
                tint = Color.White.copy(alpha = 0.2f),
                modifier = Modifier
                    .size(140.dp)
                    .align(Alignment.TopStart)
                    .offset(x = (-20).dp, y = (-20).dp)
                    .rotate(180f)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    ActionIcon(
                        icon = Icons.Outlined.Share
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    ActionIcon(
                        icon = if (isSaved) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = "Save Quote",
                        tint = if (isSaved) Color.Red.copy(alpha = 0.8f) else Color.White.copy(alpha = 0.8f),
                        onClick = onFavoriteClick
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "\"${quote.text}\"",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )


                Spacer(modifier = Modifier.height(16.dp))

                HorizontalDivider(
                    modifier = Modifier
                        .width(60.dp)
                        .padding(bottom = 8.dp),
                    thickness = 1.dp,
                    color = Color.White.copy(alpha = 0.6f)
                )

                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.titleMedium, // PT Serif Bold Italic
                    color = Color.White.copy(alpha = 0.8f)
                )
            }
        }
    }
}

@Composable
fun ActionIcon(
    icon: ImageVector,
    contentDescription: String? = null,
    tint: Color = Color.White,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(Color.White.copy(alpha = 0.2f), shape = RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = tint,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Preview
@Composable
fun QuoteItemPreview() {
    QuotesTheme {
        QuoteItemComponent(getAllQuotes()[0])
    }
}
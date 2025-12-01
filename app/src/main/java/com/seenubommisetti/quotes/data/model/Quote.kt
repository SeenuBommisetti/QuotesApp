package com.seenubommisetti.quotes.data.model

import com.seenubommisetti.quotes.data.QuoteCategory

data class Quote(
    val id: Int,
    val text: String,
    val author: String,
    val category: QuoteCategory,
    val avatar: String = "👤",
)
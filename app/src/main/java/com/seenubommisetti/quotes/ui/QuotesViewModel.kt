package com.seenubommisetti.quotes.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.seenubommisetti.quotes.data.QuoteCategory
import com.seenubommisetti.quotes.data.QuotesDataSource
import com.seenubommisetti.quotes.data.model.Quote
import kotlin.enums.EnumEntries


class QuotesViewModel : ViewModel() {

    private val quotes = getAllQuotes()
    private val savedQuotes = mutableStateListOf<Quote>()



    fun fetchQuotes(): List<Quote> {
       return quotes
    }

    fun getAllSavedQuotes(): List<Quote> {
        return savedQuotes
    }

    fun getAllQuoteCategories(): EnumEntries<QuoteCategory> {
        return QuoteCategory.entries
    }


    fun toggleFavorite(quote: Quote) {
        if (savedQuotes.contains(quote)) {
            savedQuotes.remove(quote)
        } else {
            savedQuotes.add(quote)
        }
    }

    fun isFavorite(quote: Quote): Boolean {
        return savedQuotes.contains(quote)
    }

    init {
        fetchQuotes()
    }

    fun getAllQuotes(): List<Quote> {
        return QuotesDataSource.quotes
    }
}
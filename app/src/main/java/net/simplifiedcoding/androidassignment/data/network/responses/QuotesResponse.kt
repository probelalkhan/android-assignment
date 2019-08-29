package net.simplifiedcoding.androidassignment.data.network.responses

import net.simplifiedcoding.androidassignment.data.db.entities.Quote

data class QuotesResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)
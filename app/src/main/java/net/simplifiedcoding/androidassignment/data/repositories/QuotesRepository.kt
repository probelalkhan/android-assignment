package net.simplifiedcoding.androidassignment.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.simplifiedcoding.androidassignment.data.db.AppDatabase
import net.simplifiedcoding.androidassignment.data.db.entities.Quote
import net.simplifiedcoding.androidassignment.data.network.MyApi
import net.simplifiedcoding.androidassignment.data.network.SafeApiRequest
import net.simplifiedcoding.mvvmsampleapp.util.Coroutines


class QuotesRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {

    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.observeForever {
            saveQuotes(it)
        }
    }

    suspend fun getQuotes(): LiveData<List<Quote>> {
        return withContext(Dispatchers.IO) {
            fetchQuotes()
            db.getQuoteDao().getQuotes()
        }
    }

    private suspend fun fetchQuotes() {
        val response = apiRequest { api.getQuotes() }
        quotes.postValue(response.quotes)
    }


    private fun saveQuotes(quotes: List<Quote>) {
        Coroutines.io {
            db.getQuoteDao().saveAllQuotes(quotes)
        }
    }

}
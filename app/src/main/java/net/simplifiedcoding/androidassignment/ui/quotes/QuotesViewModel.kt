package net.simplifiedcoding.androidassignment.ui.quotes

import androidx.lifecycle.ViewModel;
import net.simplifiedcoding.androidassignment.data.repositories.QuotesRepository
import net.simplifiedcoding.mvvmsampleapp.util.lazyDeferred

class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}

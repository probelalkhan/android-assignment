package net.simplifiedcoding.androidassignment.ui.quotes

import com.xwray.groupie.databinding.BindableItem
import net.simplifiedcoding.androidassignment.R
import net.simplifiedcoding.androidassignment.data.db.entities.Quote
import net.simplifiedcoding.androidassignment.databinding.ItemQuoteBinding

class QuoteItem(
    private val quote: Quote
) : BindableItem<ItemQuoteBinding>(){

    override fun getLayout() = R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.setQuote(quote)
    }
}
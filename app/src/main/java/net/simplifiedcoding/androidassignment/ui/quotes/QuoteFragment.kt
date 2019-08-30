package net.simplifiedcoding.androidassignment.ui.quotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_quote.*
import net.simplifiedcoding.androidassignment.R


class QuoteFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quote, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments?.let {
            val args = QuoteFragmentArgs.fromBundle(it)
            text_view_quote.text = args.quote.quote
            text_view_author.text = args.quote.author
        }

    }

}

package com.example.acronyms

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.acronyms.data.Meaning

/**
 * When there is no Mars property data (data is null), hide the [RecyclerView], otherwise show it.
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Meaning>?) {
    val adapter = recyclerView.adapter as MeaningAdapter
    adapter.submitList(data)
}
package com.example.acronyms

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.acronyms.databinding.ListItemMeaningBinding
import com.example.acronyms.data.Meaning

class MeaningAdapter: ListAdapter<Meaning, RecyclerView.ViewHolder>(MeaningDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            val meaningItem = getItem(position) as Meaning
            holder.bind(meaningItem)
        }
    }

    class ViewHolder private constructor(val binding: ListItemMeaningBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Meaning) {
            binding.meaning = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemMeaningBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}



class MeaningDiffCallback: DiffUtil.ItemCallback<Meaning>() {
    override fun areItemsTheSame(oldItem: Meaning, newItem: Meaning): Boolean {
        return oldItem.longForm == newItem.longForm
    }

    override fun areContentsTheSame(oldItem: Meaning, newItem: Meaning): Boolean {
        return oldItem.longForm == newItem.longForm
    }
}
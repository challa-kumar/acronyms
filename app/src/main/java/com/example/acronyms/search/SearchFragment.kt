package com.example.acronyms.search

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.acronyms.MeaningAdapter
import com.example.acronyms.R
import com.example.acronyms.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private lateinit var viewModel: SearchViewModel
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_search,
            container,
            false
        )
        viewModel = ViewModelProvider(this)[SearchViewModel::class.java]
        binding.searchViewModel = viewModel
        binding.lifecycleOwner = this
        val layoutManager = LinearLayoutManager(activity)
        binding.meaningsList.layoutManager = layoutManager
        val adapter = MeaningAdapter()
        binding.meaningsList.adapter = adapter
        return binding.root
    }
}
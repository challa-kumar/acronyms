package com.example.acronyms.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.acronyms.data.Meaning
import com.example.acronyms.network.MeaningsApi
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    var searchText: String = ""

    private val _meaningList = MutableLiveData<List<Meaning>>()
    val meaningList: LiveData<List<Meaning>>
        get() = _meaningList

    fun onSearchClick() {
        viewModelScope.launch {
            if (searchText.isEmpty() || searchText.isBlank()) {
                _meaningList.postValue(emptyList())
            } else {
                _meaningList.value = MeaningsApi.getMeanings(searchText)
            }
        }
    }
}
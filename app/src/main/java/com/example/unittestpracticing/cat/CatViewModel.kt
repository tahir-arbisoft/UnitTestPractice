package com.example.unittestpracticing.cat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CatViewModel(private val repository: CatRepository) : ViewModel() {

    private val _cuteCats = MutableLiveData<List<Cat>>()
    val cuteCats: LiveData<List<Cat>> = _cuteCats

    fun getCuteCats() = viewModelScope.launch {
        val cuteCats = repository.getCuteCats()
        _cuteCats.value = cuteCats
    }
}
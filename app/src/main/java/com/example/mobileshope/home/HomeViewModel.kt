package com.example.mobileshope.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileshope.api.MainAPI
import com.example.mobileshope.model.HomeResponse
import com.example.mobileshope.util.CategoryGenerator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val mainAPI: MainAPI) : ViewModel() {

    private val _content = MutableLiveData<HomeResponse>()
    val content: LiveData<HomeResponse> get() = _content

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val home = mainAPI.getHome()
                val categories = CategoryGenerator.generateCategory()
                withContext(Dispatchers.Main) { _content.value = home }
            } catch (e: Exception) {

            }
        }
    }
}
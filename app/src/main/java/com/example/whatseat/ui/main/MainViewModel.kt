package com.example.whatseat.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.whatseat.data.model.Repository

class MainViewModel() : ViewModel() {
    private val viewStateLiveData: MutableLiveData<MainViewState> =
        MutableLiveData()

    init {
        Repository.getRecipesRepository().observeForever {
            viewStateLiveData.value = MainViewState(it)
        }
    }

    fun viewState(): LiveData<MainViewState> = viewStateLiveData

    fun updateByProducts(products: String) {
        Repository.updateRecipesByProducts(products)
    }

}


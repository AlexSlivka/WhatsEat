package com.example.whatseat.data.model

import androidx.lifecycle.LiveData

interface IRepository {

    fun updateRecipesByProducts(products: String)

    fun getRecipesRepository(): LiveData<List<Recipe>>

    fun getRecipeById(id: Int) : Recipe
}
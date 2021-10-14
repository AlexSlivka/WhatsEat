package com.example.whatseat.api

import com.example.whatseat.data.model.Recipe
import retrofit2.http.GET
import retrofit2.http.Query

interface IRecipeApi {

    @GET("dishes?")
    suspend fun getRecipes(@Query("products") products: String): List<Recipe>
}


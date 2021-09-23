package com.example.whatseat.api

import com.example.whatseat.data.model.Recipe
import retrofit2.http.GET
import retrofit2.http.Query

interface IRecipeApi {

    @GET("products?")
    suspend fun getRecipes(@Query("products") products: String): List<Recipe>
}


val baseUrl: String = "185.46.8.32:8080/whatseat/api/v1/"
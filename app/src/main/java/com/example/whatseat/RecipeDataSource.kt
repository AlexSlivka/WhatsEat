package com.example.whatseat

import com.example.whatseat.api.NetworkModule
import com.example.whatseat.data.model.Recipe

class RecipeDataSource {
    private val theRecipeApiService = NetworkModule.theRecipeApiService
    lateinit var recipesList: List<Recipe>

    suspend fun getRecipes(products: String): List<Recipe> {
        recipesList = theRecipeApiService.getRecipes(products)
        return recipesList
    }

    fun getRecipeById(id: Int): Recipe {
        for (rep in recipesList) {
            if (rep.idRecipe == id) {
                return rep
            }
        }

        return Recipe(0, "Ничего", "Сщисем ничего", R.drawable.image_recipe)

    }

}
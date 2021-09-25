package com.example.whatseat.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.whatseat.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

object Repository {

    private val uiScope = CoroutineScope(Dispatchers.IO)

    private val recipesLiveData = MutableLiveData<List<Recipe>>()

    private val recipes: MutableList<Recipe> = mutableListOf(
        Recipe(
            1,
            "Первое блюдо",
            "Как приготовить первое блюдо", R.drawable.image_recipe
        ),
        Recipe(
            2,
            "Второе блюдо",
            "Как приготовить второе блюдо", R.drawable.image_recipe
        ),
        Recipe(
            3,
            "Третье блюдо",
            "Как приготовить третье блюдо", R.drawable.image_recipe
        ),
        Recipe(
            4,
            "Четвертое блюдо",
            "Как приготовить 4-е блюдо", R.drawable.image_recipe
        )
    )

    init {
        recipesLiveData.value = recipes
    }

    fun updateRecipesByProducts(products: String) {
        //uiScope.launch { NetworkModule.theRecipeApiService.getRecipes(products ) }
        addOrReplace(products)
        recipesLiveData.value = recipes
    }

    private fun addOrReplace(products: String) {
        val recipeAdd = Recipe(
            55,
            products,
            "Как приготовить$products", R.drawable.image_recipe
        )

        recipes.add(recipeAdd)
    }

    fun getRecipesRepository(): LiveData<List<Recipe>> {
        return recipesLiveData
    }


    fun getRecipeById(id: Int): Recipe {
        for (rep in recipes) {
            if (rep.idRecipe == id) {
                return rep
            }
        }

        return Recipe(0, "Ничего", "Совсем ничего", R.drawable.image_recipe)

    }

}


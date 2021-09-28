package com.example.whatseat.data.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.whatseat.R
import com.example.whatseat.api.NetworkModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "Repository"

object Repository {

    private val uiScope = CoroutineScope(Dispatchers.IO)

    private val recipesLiveData = MutableLiveData<List<Recipe>>()

    private var recipes: MutableList<Recipe> = mutableListOf(
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
        Log.d(TAG, "Запрос на сервер")
        uiScope.launch {
            recipes = NetworkModule.theRecipeApiService.getRecipes(products).toMutableList()
            Log.d(TAG, recipes.size.toString())
            Log.d(TAG, recipes.toString())
            recipesLiveData.postValue(recipes)
        }

        // recipesLiveData.value = recipes
    }


    fun getRecipesRepository(): LiveData<List<Recipe>> {
        return recipesLiveData
    }

    fun getRecipeById(id: Int): Recipe {
        for (rep in recipes) {
            if (rep.idRecipe == id) {
                rep.textRecipe = rep.textRecipe
                    .filterNot { it == "<"[0] || it == ">"[0] || it == "l"[0] || it == "i"[0] || it == "/"[0] }


                return rep
            }
        }
// it == "</li>".get(5)
        return Recipe(0, "Ничего", "Совсем ничего", R.drawable.image_recipe)

    }

}


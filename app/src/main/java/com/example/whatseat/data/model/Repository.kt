package com.example.whatseat.data.model

import com.example.whatseat.R

object Repository {
    private val resipes: List<Recipe>

    init {
        resipes = listOf(
            Recipe( 1 ,
                "Первое блюдо" ,
                "Как приготовить первое блюдо", R.drawable.image_recipe),
            Recipe( 2 ,
                "Второе блюдо" ,
                "Как приготовить второе блюдо", R.drawable.image_recipe),
            Recipe( 3 ,
                "Третье блюдо" ,
                "Как приготовить третье блюдо", R.drawable.image_recipe),
            Recipe( 4 ,
                "Четвертое блюдо" ,
                "Как приготовить 4-е блюдо", R.drawable.image_recipe)
        )
    }

    fun getRecipesRepository (): List<Recipe> {
        return resipes
    }
}
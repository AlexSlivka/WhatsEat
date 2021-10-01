package com.example.whatseat.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.whatseat.R
import com.example.whatseat.data.model.Recipe
import com.example.whatseat.data.model.Repository

private const val TAG = "RecipeCardFragment"
const val BASE_URL_IMG_RECIPE = "http://185.46.8.32:8080/whatseat/"

class RecipeCardFragment : Fragment() {
    private lateinit var recipe: Recipe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipe = arguments?.getInt(RECIPE_CARD_ARG)?.let { Repository.getRecipeById(it) }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_recipe_card, container, false)
        view.findViewById<TextView>(R.id.tv_name_recipe_card).text = recipe.nameRecipe
        view.findViewById<TextView>(R.id.tv_text_recipe_card).text = recipe.textRecipe
        val posterHolderCard: ImageView = view.findViewById(R.id.iv_poster_of_recipe_card)
        val recipeImg = BASE_URL_IMG_RECIPE + recipe.imgRecipe
        Glide.with(view.context)
            .load(recipeImg)
            .placeholder(R.drawable.image_recipe)
            .into(posterHolderCard)

        Toast.makeText(context, recipe.imgRecipe, Toast.LENGTH_LONG)
            .show()
        Log.d(TAG, recipe.imgRecipe)
        return view
    }

    companion object {
        private const val RECIPE_CARD_ARG = "recipeCard"

        fun newInstance(recipeId: Int) = RecipeCardFragment().apply {
            arguments = Bundle().apply {
                putInt(RECIPE_CARD_ARG, recipeId)
            }
        }
    }
}

/*
companion object {
    private const val RECIPE_CARD_ARG = "recipeCard"

    fun newInstance(recipe: Recipe) = RecipeCardFragment().apply {
        arguments = Bundle().apply {
            putParcelable(RECIPE_CARD_ARG, recipe)
        }
    }
}
}

recipe = arguments?.getParcelable(RECIPE_CARD_ARG) ?: Recipe(
"Вода со льдом",
R.drawable.image_recipe,
"Вода и лед"
)

*/
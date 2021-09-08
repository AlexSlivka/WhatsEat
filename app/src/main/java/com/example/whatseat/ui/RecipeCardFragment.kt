package com.example.whatseat.ui

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.whatseat.R
import com.example.whatseat.Recipe

class RecipeCardFragment : Fragment() {
    private lateinit var recipe: Recipe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipe = arguments?.getParcelable(RECIPE_CARD_ARG) ?: Recipe(
            "Вода со льдом",
            R.drawable.image_recipe,
            "Вода и лед"
        )
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
        Glide.with(view.context)
            .load(recipe.poster)
            .into(posterHolderCard)

        return view
    }

    companion object {
        private const val RECIPE_CARD_ARG = "recipeCard"

        fun newInstance(recipe: Recipe) = RecipeCardFragment().apply {
            arguments = Bundle().apply {
                putParcelable(RECIPE_CARD_ARG, recipe)
            }
        }
    }
}
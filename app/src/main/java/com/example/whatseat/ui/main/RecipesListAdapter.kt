package com.example.whatseat.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.whatseat.R
import com.example.whatseat.data.model.Recipe

class RecipesListAdapter(private val clickListener: OnRecyclerItemClicked) :
    RecyclerView.Adapter<RecipesListAdapter.RecipesListViewHolder>() {

    private var recipes: List<Recipe> = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesListViewHolder {
        return RecipesListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_recipe, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecipesListViewHolder, position: Int) {
        holder.onBind(recipes[position])
        holder.itemView.setOnClickListener { clickListener.onClick(recipes[position]) }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun bindRecipes(newRecipes: List<Recipe>) {
        recipes = newRecipes
        notifyDataSetChanged()
    }

    class RecipesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameRecipeHolder: TextView =
            itemView.findViewById(R.id.tv_name_recipe)
        private val posterHolder: ImageView = itemView.findViewById(R.id.iv_poster_of_recipe)

        fun onBind(recipe: Recipe) {
            Glide.with(itemView.context)
                .load(BASE_URL_IMG_RECIPE + recipe.imgRecipe)
                .apply(imageOption)
                .into(posterHolder)

            nameRecipeHolder.text = recipe.nameRecipe
        }

        companion object {
            private val imageOption = RequestOptions()
                .placeholder(R.drawable.ic_avatar_placeholder)
                .fallback(R.drawable.ic_avatar_placeholder)
        }
    }
}

interface OnRecyclerItemClicked {
    fun onClick(movie: Recipe)
}

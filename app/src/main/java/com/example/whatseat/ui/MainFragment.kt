package com.example.whatseat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatseat.R
import com.example.whatseat.Recipe
import com.example.whatseat.RecipeDataSource

class MainFragment : Fragment() {
    private var recyclerRecipesList: RecyclerView? = null
    private var adapterRecipesList: RecipesListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerRecipesList = view.findViewById(R.id.rv_recipe_list)
        adapterRecipesList = RecipesListAdapter(clickListener)
        recyclerRecipesList?.adapter = adapterRecipesList
        val displayMetrics = context?.resources?.displayMetrics
        val screenWidthDp = displayMetrics!!.widthPixels / displayMetrics.density
        val columnWidthDp =
            resources.getDimensionPixelSize(R.dimen.width_holder_movie) / displayMetrics.density
        val noOfColumns = (screenWidthDp / columnWidthDp).toInt()
        recyclerRecipesList?.layoutManager = GridLayoutManager(context, noOfColumns)
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    override fun onDetach() {
        recyclerRecipesList = null
        super.onDetach()
    }

    private fun updateData() {
        adapterRecipesList?.bindRecipes(RecipeDataSource().getRecipes())
    }

    private fun doOnClick(recipe: Recipe) {
        fragmentManager?.beginTransaction()
            ?.addToBackStack(null)
            ?.replace(R.id.main_container, RecipeCardFragment.newInstance(recipe))
            ?.commit()

    }

    private val clickListener = object : OnRecyclerItemClicked {
        override fun onClick(movie: Recipe) {
            doOnClick(movie)
        }
    }
}
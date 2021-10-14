package com.example.whatseat.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatseat.R
import com.example.whatseat.data.model.Recipe
import com.example.whatseat.ui.OnRecyclerItemClicked
import com.example.whatseat.ui.RecipeCardFragment
import com.example.whatseat.ui.RecipesListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

private const val TAG = "MainFragment"

class MainFragment : Fragment() {
    private var recyclerRecipesList: RecyclerView? = null
    private var adapterRecipesList: RecipesListAdapter? = null
    private val uiScope = CoroutineScope(Dispatchers.IO)
    lateinit var viewModel: MainViewModel
    lateinit var editTextView: TextView
    lateinit var searchButton: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        editTextView = view.findViewById(R.id.editText_search)
        searchButton = view.findViewById(R.id.btn_search)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        recyclerRecipesList = view.findViewById(R.id.rv_recipe_list)
        adapterRecipesList = RecipesListAdapter(clickListener)
        recyclerRecipesList?.adapter = adapterRecipesList

        viewModel.viewState().observe(viewLifecycleOwner, Observer<MainViewState> { t ->
            t?.let { adapterRecipesList!!.bindRecipes(it.recipes) }
        })

        searchButton.setOnClickListener {
            viewModel.updateByProducts(editTextView.text.toString())

            Log.d(TAG, viewModel.viewState().value?.recipes.toString())
        }

        val displayMetrics = context?.resources?.displayMetrics
        val screenWidthDp = displayMetrics!!.widthPixels / displayMetrics.density
        val columnWidthDp =
            resources.getDimensionPixelSize(R.dimen.width_holder_movie) / displayMetrics.density
        val noOfColumns = (screenWidthDp / columnWidthDp).toInt()

        recyclerRecipesList?.layoutManager = GridLayoutManager(context, noOfColumns)

    }

    override fun onDetach() {
        recyclerRecipesList = null
        super.onDetach()
    }

    private fun doOnClick(recipe: Recipe) {
        fragmentManager?.beginTransaction()
            ?.addToBackStack(null)
            ?.replace(R.id.nav_host_main_fragment, RecipeCardFragment.newInstance(recipe.idRecipe))
            ?.commit()

    }

    private val clickListener = object : OnRecyclerItemClicked {
        override fun onClick(movie: Recipe) {
            doOnClick(movie)
        }
    }
}
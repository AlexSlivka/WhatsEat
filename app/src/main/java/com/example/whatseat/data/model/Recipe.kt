package com.example.whatseat.data.model

import com.example.whatseat.R
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class Recipe(
    @SerialName("id") val idRecipe: Int,
    @SerialName("title") val nameRecipe: String,
    @SerialName("description") var textRecipe: String,
    @Transient val poster: Int = R.drawable.image_recipe
)
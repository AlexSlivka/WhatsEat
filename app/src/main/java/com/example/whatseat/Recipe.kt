package com.example.whatseat

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipe(
    val nameRecipe: String,
    val poster: Int,
    val textRecipe: String
) : Parcelable
package com.arya.gamecatalogue.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val id: Int,
    val name: String,
    val released: String,
    val rating: Double,
    val backgroundImage: String,
    val metacritic: Int,
    val playtime: Int,
    val esrbRating: String,
    val platforms: List<String>,
    val genres: List<String>,
    val shortScreenshots: List<String>,
    val isFavorite: Boolean
) : Parcelable

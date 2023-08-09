package com.arya.gamecatalogue.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GameEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "released")
    var released: String,

    @ColumnInfo(name = "rating")
    var rating: Double,

    @ColumnInfo(name = "rating_top")
    var metacritic: Int,

    @ColumnInfo(name = "playtime")
    var playtime: Int,

    @ColumnInfo(name = "esrb_rating")
    var esrbRating: String,

    @ColumnInfo(name = "platforms")
    var platforms: String,

    @ColumnInfo(name = "genres")
    var genres: String,

    @ColumnInfo(name = "background_image")
    var backgroundImage: String,

    @ColumnInfo(name = "short_screenshot")
    var shortScreenshot: String,

    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false
)

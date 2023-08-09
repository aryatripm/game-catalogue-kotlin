package com.arya.gamecatalogue.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GameResponse(

	@field:SerializedName("background_image")
	val backgroundImage: String? = null,

	@field:SerializedName("esrb_rating")
	val esrbRating: EsrbRating? = null,

	@field:SerializedName("genres")
	val genres: List<GenreItem?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("rating")
	val rating: Double? = null,

	@field:SerializedName("metacritic")
	val metacritic: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("playtime")
	val playtime: Int? = null,

	@field:SerializedName("parent_platforms")
	val platforms: List<PlatformItem?>? = null,

	@field:SerializedName("short_screenshots")
	val shortScreenshots: List<ShortScreenshotItem?>? = null,

	@field:SerializedName("released")
	val released: String? = null
)

data class EsrbRating(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("slug")
	val slug: String? = null
)

data class PlatformBody(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("slug")
	val slug: String? = null
)

data class GenreItem(

	@field:SerializedName("games_count")
	val gamesCount: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("image_background")
	val imageBackground: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null
)

data class PlatformItem(

	@field:SerializedName("platform")
	val platform: PlatformBody? = null
)

data class ShortScreenshotItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

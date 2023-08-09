package com.arya.gamecatalogue.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GamesResponse(

	@field:SerializedName("next")
	val next: String? = null,

	@field:SerializedName("previous")
	val previous: String? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("results")
	val results: List<GameResponse>
)
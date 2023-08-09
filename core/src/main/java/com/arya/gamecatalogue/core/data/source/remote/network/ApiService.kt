package com.arya.gamecatalogue.core.data.source.remote.network

import com.arya.gamecatalogue.core.data.source.remote.response.GamesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("games")
    suspend fun getList(
        @Query("key") key: String
    ): GamesResponse

}
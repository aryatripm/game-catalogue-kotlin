package com.arya.gamecatalogue.core.data.source.remote

import android.util.Log
import com.arya.gamecatalogue.core.data.source.remote.network.ApiResponse
import com.arya.gamecatalogue.core.data.source.remote.network.ApiService
import com.arya.gamecatalogue.core.data.source.remote.response.GameResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllGame(api: String): Flow<ApiResponse<List<GameResponse>>> {
        return flow {
            try {
                Log.d("RemoteDataSource", api)
                val response = apiService.getList(api)
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

}
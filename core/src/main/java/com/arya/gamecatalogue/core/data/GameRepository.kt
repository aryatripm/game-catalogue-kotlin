package com.arya.gamecatalogue.core.data

import com.arya.gamecatalogue.core.data.source.local.LocalDataSource
import com.arya.gamecatalogue.core.data.source.remote.RemoteDataSource
import com.arya.gamecatalogue.core.data.source.remote.network.ApiResponse
import com.arya.gamecatalogue.core.data.source.remote.response.GameResponse
import com.arya.gamecatalogue.core.domain.model.Game
import com.arya.gamecatalogue.core.domain.repository.IGameRepository
import com.arya.gamecatalogue.core.utils.AppExecutors
import com.arya.gamecatalogue.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IGameRepository {

    override fun getAllGame(): Flow<Resource<List<Game>>> =
        object : NetworkBoundResource<List<Game>, List<GameResponse>>() {
            override fun loadFromDB(): Flow<List<Game>> {
                return localDataSource.getAllGame().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Game>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<GameResponse>>> = remoteDataSource.getAllGame("e41ad993fbd14ca3bcae0f7774a685ad")

            override suspend fun saveCallResult(data: List<GameResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertGame(tourismList)
            }
        }.asFlow()

    override fun getFavoriteGame(): Flow<List<Game>> {
        return localDataSource.getFavoriteGame().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteGame(game: Game, state: Boolean) {
        val gameEntity = DataMapper.mapDomainToEntity(game)
        appExecutors.diskIO().execute { localDataSource.setFavoriteGame(gameEntity, state) }
    }


}
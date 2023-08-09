package com.arya.gamecatalogue.core.data.source.local

import com.arya.gamecatalogue.core.data.source.local.entity.GameEntity
import com.arya.gamecatalogue.core.data.source.local.room.GameDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val gameDao: GameDao) {

    fun getAllGame(): Flow<List<GameEntity>> = gameDao.getAllGame()

    fun getFavoriteGame(): Flow<List<GameEntity>> = gameDao.getFavoriteGame()

    suspend fun insertGame(games: List<GameEntity>) = gameDao.insertGame(games)

    fun setFavoriteGame(game: GameEntity, newState: Boolean) {
        game.isFavorite = newState
        gameDao.updateFavoriteGame(game)
    }

}
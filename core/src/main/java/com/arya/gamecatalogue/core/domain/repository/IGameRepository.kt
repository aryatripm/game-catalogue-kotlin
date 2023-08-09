package com.arya.gamecatalogue.core.domain.repository

import com.arya.gamecatalogue.core.data.Resource
import com.arya.gamecatalogue.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface IGameRepository {

    fun getAllGame(): Flow<Resource<List<Game>>>

    fun getFavoriteGame(): Flow<List<Game>>

    fun setFavoriteGame(game: Game, state: Boolean)

}
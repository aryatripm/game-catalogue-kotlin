package com.arya.gamecatalogue.core.domain.usecase

import com.arya.gamecatalogue.core.data.Resource
import com.arya.gamecatalogue.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameUseCase {

    fun getAllGame(): Flow<Resource<List<Game>>>

    fun getFavoriteGame(): Flow<List<Game>>

    fun setFavoriteGame(tourism: Game, state: Boolean)

}
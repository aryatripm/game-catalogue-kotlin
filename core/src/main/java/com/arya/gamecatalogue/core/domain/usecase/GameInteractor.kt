package com.arya.gamecatalogue.core.domain.usecase

import com.arya.gamecatalogue.core.data.Resource
import com.arya.gamecatalogue.core.domain.model.Game
import com.arya.gamecatalogue.core.domain.repository.IGameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameInteractor @Inject constructor(private val gameRepository: IGameRepository): GameUseCase {

    override fun getAllGame(): Flow<Resource<List<Game>>> = gameRepository.getAllGame()

    override fun getFavoriteGame(): Flow<List<Game>> = gameRepository.getFavoriteGame()

    override fun setFavoriteGame(tourism: Game, state: Boolean) = gameRepository.setFavoriteGame(tourism, state)

}
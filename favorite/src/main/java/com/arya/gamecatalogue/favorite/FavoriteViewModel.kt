package com.arya.gamecatalogue.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.arya.gamecatalogue.core.domain.usecase.GameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class FavoriteViewModel(gameUseCase: GameUseCase) : ViewModel() {
    val favoriteGames = gameUseCase.getFavoriteGame().asLiveData()
}
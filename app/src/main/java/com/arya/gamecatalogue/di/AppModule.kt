package com.arya.gamecatalogue.di

import com.arya.gamecatalogue.core.domain.usecase.GameInteractor
import com.arya.gamecatalogue.core.domain.usecase.GameUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideGameUseCase(gameInteractor: GameInteractor): GameUseCase

}
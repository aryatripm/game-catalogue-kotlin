package com.arya.gamecatalogue.core.utils

import com.arya.gamecatalogue.core.data.source.local.entity.GameEntity
import com.arya.gamecatalogue.core.data.source.remote.response.GameResponse
import com.arya.gamecatalogue.core.domain.model.Game

object DataMapper {

    fun mapResponsesToEntities(input: List<GameResponse>): List<GameEntity> {
        val games = ArrayList<GameEntity>()
        input.map {
            val game = GameEntity(
                id = it.id ?: 0,
                name = it.name ?: "",
                released = it.released ?: "",
                backgroundImage = it.backgroundImage ?: "",
                rating = it.rating ?: 0.0,
                metacritic = it.metacritic ?: 0,
                playtime = it.playtime ?: 0,
                genres = it.genres?.joinToString(separator = ",") { genre -> genre?.name ?: "" } ?: "",
                platforms = it.platforms?.joinToString(separator = ",") { platform -> platform?.platform?.name ?: "" } ?: "",
                esrbRating = it.esrbRating?.name ?: "",
                shortScreenshot = it.shortScreenshots?.joinToString(separator = ",") { screenshot -> screenshot?.image ?: "" } ?: "",
                isFavorite = false
            )
            games.add(game)
        }
        return games
    }

    fun mapEntitiesToDomain(input: List<GameEntity>): List<Game> =
        input.map {
            Game(
                id = it.id,
                name = it.name,
                released = it.released,
                backgroundImage = it.backgroundImage,
                rating = it.rating,
                metacritic = it.metacritic,
                playtime = it.playtime,
                genres = it.genres.split(","),
                platforms = it.platforms.split(","),
                esrbRating = it.esrbRating,
                shortScreenshots = it.shortScreenshot.split(","),
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Game) = GameEntity(
        id = input.id,
        name = input.name,
        released = input.released,
        backgroundImage = input.backgroundImage,
        rating = input.rating,
        metacritic = input.metacritic,
        playtime = input.playtime,
        genres = input.genres.joinToString(separator = ","),
        platforms = input.platforms.joinToString(separator = ","),
        esrbRating = input.esrbRating,
        shortScreenshot = input.shortScreenshots.joinToString(separator = ","),
        isFavorite = input.isFavorite
    )

}
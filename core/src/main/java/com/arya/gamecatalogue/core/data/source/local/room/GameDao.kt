package com.arya.gamecatalogue.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.arya.gamecatalogue.core.data.source.local.entity.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Query("SELECT * FROM games")
    fun getAllGame(): Flow<List<GameEntity>>

    @Query("SELECT * FROM games where is_favorite = 1")
    fun getFavoriteGame(): Flow<List<GameEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(games: List<GameEntity>)

    @Update
    fun updateFavoriteGame(games: GameEntity)

}
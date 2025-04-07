package com.example.gameplan.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface GameDao {

    // update or insert game
    // suspend creates coroutine
    @Upsert
    fun upsertGame(gameEntity: GameEntity)

    // delete game
    // suspend creates coroutine
    @Delete
    fun deleteGame(gameEntity: GameEntity)

    // get all games
    @Query("SELECT * FROM savedGames")
    fun getSavedGames(): List<GameEntity>
}
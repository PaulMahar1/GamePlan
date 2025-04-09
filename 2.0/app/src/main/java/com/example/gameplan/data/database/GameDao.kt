package com.example.gameplan.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface GameDao {

    // update or insert game
    @Upsert
    fun upsertGame(gameEntity: GameEntity)

    //testing delete
    @Query("DELETE FROM savedGames WHERE gameId = :id")
    fun deleteGame(id: Int?)

    // get all games
    @Query("SELECT * FROM savedGames")
    fun getSavedGames(): List<GameEntity>
}
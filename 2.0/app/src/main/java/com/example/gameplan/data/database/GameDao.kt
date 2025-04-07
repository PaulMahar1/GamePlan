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
    fun upsertGame(game: Game)

    // delete game
    // suspend creates coroutine
    @Delete
    fun deleteGame(game: Game)

    // get all games
    @Query("SELECT * FROM savedGames")
    fun getSavedGames(): List<Game>
}
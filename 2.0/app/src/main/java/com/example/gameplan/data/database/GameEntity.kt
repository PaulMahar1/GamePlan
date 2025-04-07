package com.example.gameplan.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "savedGames")
data class GameEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val gameId: Int,
    val gameName: String,
    val gameImg: String,
    val gameDesc: String
)

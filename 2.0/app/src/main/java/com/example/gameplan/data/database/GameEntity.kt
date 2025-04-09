package com.example.gameplan.data.database

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.gameplan.data.Genre

@Entity(
    tableName = "savedGames",
    indices = [Index(value = ["gameId"], unique = true)]
)
data class GameEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val gameId: Int?,
    val gameName: String?,
    val gameImg: String?,
    val gameDesc: String?,
    val gameGenres: List<Genre?>?
)

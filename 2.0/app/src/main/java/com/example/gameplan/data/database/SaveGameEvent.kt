package com.example.gameplan.data.database

import com.example.gameplan.data.Genre

sealed interface SaveGameEvent {

    data object SaveGame : SaveGameEvent
    data class GameId(val gameId: Int) : SaveGameEvent
    data class GameName(val gameName: String) : SaveGameEvent
    data class GameImage(val gameImage: String) : SaveGameEvent
    data class GameDesc(val gameDesc: String) : SaveGameEvent
    data class GameGenres(val gameGenres: List<Genre?>?) : SaveGameEvent
}
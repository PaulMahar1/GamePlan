package com.example.gameplan.data.database

sealed interface SaveGameEvent {

    data object SaveGame: SaveGameEvent
    data class GameId(val gameId: Int): SaveGameEvent
    data class GameName(val gameName: String): SaveGameEvent
    data class GameImage(val gameImage: String): SaveGameEvent
    data class GameDesc(val gameDesc: String): SaveGameEvent
}
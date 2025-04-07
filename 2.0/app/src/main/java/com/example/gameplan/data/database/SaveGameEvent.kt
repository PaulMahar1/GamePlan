package com.example.gameplan.data.database

sealed interface SaveGameEvent {

    object SaveGame: SaveGameEvent
    data class gameId(val gameId: Int): SaveGameEvent
    data class gameName(val gameName: String): SaveGameEvent
    data class gameImage(val gameImage: String): SaveGameEvent
    data class gameDesc(val gameDesc: String): SaveGameEvent


}
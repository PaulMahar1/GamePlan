package com.example.gameplan.data

import com.google.gson.annotations.SerializedName

data class OwnedGames(
    @SerializedName("response")
    val ownedGamesResponse: OwnedGamesResponse?
)

data class OwnedGamesResponse(
    @SerializedName("game_count")
    val gameCount: Int?,
    @SerializedName("games")
    val games: List<Game?>?
)

data class Game(
    @SerializedName("appid")
    val appid: Int?,
    @SerializedName("playtime_deck_forever")
    val playtimeDeckForever: Int?,
    @SerializedName("playtime_disconnected")
    val playtimeDisconnected: Int?,
    @SerializedName("playtime_forever")
    val playtimeForever: Int?,
    @SerializedName("playtime_linux_forever")
    val playtimeLinuxForever: Int?,
    @SerializedName("playtime_mac_forever")
    val playtimeMacForever: Int?,
    @SerializedName("playtime_windows_forever")
    val playtimeWindowsForever: Int?,
    @SerializedName("rtime_last_played")
    val rtimeLastPlayed: Int?
)



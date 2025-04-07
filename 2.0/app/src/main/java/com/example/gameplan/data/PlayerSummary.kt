package com.example.gameplan.data

import com.google.gson.annotations.SerializedName

data class PlayerSummary(
    @SerializedName("response")
    val playerSummaryResponse: PlayerSummaryResponse
)

data class PlayerSummaryResponse(
    @SerializedName("players")
    val players: List<Player?>?
)

data class Player(
    @SerializedName("avatar")
    val avatar: String?,
    @SerializedName("avatarfull")
    val avatarfull: String?,
    @SerializedName("avatarhash")
    val avatarhash: String?,
    @SerializedName("avatarmedium")
    val avatarmedium: String?,
    @SerializedName("communityvisibilitystate")
    val communityvisibilitystate: Int?,
    @SerializedName("lastlogoff")
    val lastlogoff: Int?,
    @SerializedName("loccountrycode")
    val loccountrycode: String?,
    @SerializedName("personaname")
    val personaname: String?,
    @SerializedName("personastate")
    val personastate: Int?,
    @SerializedName("personastateflags")
    val personastateflags: Int?,
    @SerializedName("primaryclanid")
    val primaryclanid: String?,
    @SerializedName("profilestate")
    val profilestate: Int?,
    @SerializedName("profileurl")
    val profileurl: String?,
    @SerializedName("steamid")
    val steamid: String?,
    @SerializedName("timecreated")
    val timecreated: Int?
)


package com.example.gameplan.data

import com.google.gson.annotations.SerializedName

data class GameInfo2(
    @SerializedName("appid")
    val appid: Int?,
    @SerializedName("average_2weeks")
    val average2weeks: Int?,
    @SerializedName("average_forever")
    val averageForever: Int?,
    @SerializedName("ccu")
    val ccu: Int?,
    @SerializedName("developer")
    val developer: String?,
    @SerializedName("discount")
    val discount: String?,
    @SerializedName("genre")
    val genre: String?,
    @SerializedName("initialprice")
    val initialprice: String?,
    @SerializedName("languages")
    val languages: String?,
    @SerializedName("median_2weeks")
    val median2weeks: Int?,
    @SerializedName("median_forever")
    val medianForever: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("negative")
    val negative: Int?,
    @SerializedName("owners")
    val owners: String?,
    @SerializedName("positive")
    val positive: Int?,
    @SerializedName("price")
    val price: String?,
    @SerializedName("publisher")
    val publisher: String?,
    @SerializedName("score_rank")
    val scoreRank: String?,
    @SerializedName("tags")
    val tags: Map<String, Int>?,
    @SerializedName("userscore")
    val userscore: Int?
)


//Loop through the list of games and check if their tag map contains "Card Battler":
//
//fun findGamesWithTag(games: List<Game>, tag: String): List<Game> {
//    return games.filter { game ->
//        game.tags?.containsKey(tag) == true
//    }
//}
//
//Usage:
//val cardBattlerGames = findGamesWithTag(gamesList, "Card Battler")
//
//
//To get all tags for a specific game:
//
//fun listTagsForGame(game: Game): List<String> {
//    return game.tags?.keys?.toList() ?: emptyList()
//}
//Usage:
//
//val gameTags = listTagsForGame(someGame)
//println("Tags for this game: $gameTags")
//This will return a list like ["Card Battler", "Deckbuilding", "Roguelike"].



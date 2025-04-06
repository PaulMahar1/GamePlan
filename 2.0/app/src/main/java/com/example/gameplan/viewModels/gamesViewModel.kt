package com.example.gameplan.viewmodel

import RetrofitClient
import SteamApiService
import StoreClient
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import com.example.gameplan.data.Game
import com.example.gameplan.data.GameData
import com.example.gameplan.data.OwnedGames
import com.example.gameplan.data.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class GameListViewModel : ViewModel() {
    var gamesList:List<Int> = mutableStateListOf()
    suspend fun filterGames(players: List<Player>) =
        withContext(Dispatchers.IO) {
            var games = players.map { player ->
                getGames(player)
            }

            val commonGames: List<Game?>? = if (games.isEmpty()) {
                emptyList()
            } else {
                games.reduce { acc, playerGames ->
                    acc?.intersect(playerGames!!.toSet())?.toList()
                }
            }
            val gameIds = commonGames!!.map{ game ->
                game!!.appid!!
            }
            gamesList = gameIds

   }

    private suspend fun getGames(player: Player): List<Game?>? {
        try {
            //println("Is this getting read?")
            val response =
                RetrofitClient.api.getOwnedGames(
                    "04E7A6580B01031C53C63E003B49425F",
                    player.steamid!!
                )
            //println(response)
            if (response.isSuccessful) {
                val body = response.body()!!.ownedGamesResponse!!.games
                return body
                // println("Fetched Successfully")
            } else {

                //  println("Failed to resolve game URL")
                return null
            }
        } catch (e: Exception) {

            return null

        }
    }

}
//    var errorMessage by mutableStateOf("")
//
//
//    var errorMessage2 by mutableStateOf("")
//        private set
//
//    var gameResponse by mutableStateOf<GameData?>(null)
//        private set
//
//

//    fun fetchGames(gameId: String) {
//        viewModelScope.launch {
//            try {
//                //println("Is this getting read?")
//                val response = RetrofitClient.api.getOwnedGames("04E7A6580B01031C53C63E003B49425F",PLAYER.)
//                //println(response)
//                if (response.isSuccessful) {
//                    val body = response.body()
//                    gameResponse = body?.get(gameId)?.data
//                   // println("Fetched Successfully")
//                } else {
//                    errorMessage2 = "Failed to resolve game URL."
//                  //  println("Failed to resolve game URL")
//                }
//                println(gameResponse)
////
////                val tagsResponse = RetrofitClient.api.getGameTags(apiKey, gameId)
////                if (tagsResponse.isSuccessful) {
////                    val tags = tagsResponse.body()
////
////                }
//            } catch (e: Exception) {
//                errorMessage = "Exception: ${e.message}"
//            }
//        }
//    }

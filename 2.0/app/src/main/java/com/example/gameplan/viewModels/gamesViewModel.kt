/*TODO
    Not sure if its in here or in the friendsViewModel
        But we need to figure out why the 'go to games' button on FriendScreen crashes
        see FriendScreen To do for more info
    Make functioning api call for Selected Friends > Common Games
 */

package com.example.gameplan.viewModels

import RetrofitClient
import StoreClient
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.gameplan.data.Game
import com.example.gameplan.data.GameData
import com.example.gameplan.data.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class GameListViewModel : ViewModel() {
    var gamesList by mutableStateOf<List<Int>>(emptyList())
    suspend fun filterGames(players: List<Player>) =
        withContext(Dispatchers.IO) {
            val commonGameIds: List<Int> = players.flatMap { getGames(it)!!.mapNotNull { it?.appid } }
                .groupingBy { it }
                .eachCount()
                .filterValues { it == players.size }
                .keys.toList()
            gamesList = commonGameIds

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

    suspend fun allDetails(body: List<Int?>?): List<GameData?> {
        if (body != null) {
            val gameDataList = mutableListOf<GameData?>()
            for (item in body) {
                try {
                    val allResponse =
                        StoreClient.api.getGameDetails(
                            item.toString()
                        )

                    if (allResponse.isSuccessful) {
                        // Extract only the 'data' part from the response body
                        val gameData = allResponse.body()?.values?.firstOrNull()?.data

                        // Add the game data to the list if it exists
                        if (gameData != null) {
                            gameDataList.add(gameData)
                        } else {
                            println("No game data found for appid $item")
                        }
                    } else {
                        println("API call failed for appid $item: ${allResponse.code()}")
                    }
                } catch (e: Exception) {
                    println("Error fetching details for appid $item: ${e.message}")
                }
            }
            return gameDataList // Return the list of game data
        }
        return emptyList() // Return an empty list if 'body' is null
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

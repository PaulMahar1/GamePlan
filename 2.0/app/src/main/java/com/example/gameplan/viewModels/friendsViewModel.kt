package com.example.gameplan.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameplan.data.FriendList
import com.example.gameplan.data.Player
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class FriendListViewModel : ViewModel() {

    var friendNames by mutableStateOf<List<Player>>(emptyList())
        private set

    var errorMessage by mutableStateOf("")

    var playerId by mutableStateOf<String?>(null)
        private set

    var errorMessage2 by mutableStateOf("")
        private set




    fun fetchFriendNames(apiKey: String, steamId: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.getSteamId(apiKey, steamId)
                if (response.isSuccessful) {
                    val vanityResponse = response.body()
                    if (vanityResponse != null && vanityResponse.response.success == 1) {
                        playerId = vanityResponse.response.steamid
                        errorMessage2 = ""
                    } else {
                        errorMessage2 = "Failed to resolve vanity URL."
                    }
                }
                val friendListResponse = RetrofitClient.api.getFriendList(apiKey, playerId)
                if (friendListResponse.isSuccessful) {
                    val friends = friendListResponse.body()?.friendsListResponse?.friends?.filterNotNull()
                    println("Fetched Friends: $friends")  // Add this log to check friends

                    val ids = friends?.mapNotNull { it.steamid }?.joinToString(",")
                    println("Friend IDs: $ids")  // Add this log to check IDs

                    if (!ids.isNullOrEmpty()) {
                        val summaryResponse = RetrofitClient.api.getPlayerSummary(apiKey, ids)
                        if (summaryResponse.isSuccessful) {
                            friendNames =
                                summaryResponse.body()?.playerSummaryResponse?.players?.filterNotNull()
                                    ?: emptyList()
                            println("Player Summary: $friendNames")  // Add this log
                        } else {
                            errorMessage = "Failed to get player summaries"
                        }
                    } else {
                        errorMessage = "No friends found"
                    }
                } else {
                    errorMessage = "Error: ${friendListResponse.code()}"
                }
            } catch (e: Exception) {
                errorMessage = "Exception: ${e.message}"
            }
        }
    }
}

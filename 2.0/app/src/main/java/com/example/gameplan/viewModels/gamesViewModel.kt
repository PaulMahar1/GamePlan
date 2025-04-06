package com.example.gameplan.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.gameplan.data.GameData


class GameListViewModel : ViewModel() {

    var errorMessage by mutableStateOf("")


    var errorMessage2 by mutableStateOf("")
        private set

    var gameResponse by mutableStateOf<GameData?>(null)
        private set

    fun fetchGames(gameId: String) {
        viewModelScope.launch {
            try {
                println("Is this getting read?")
                val response = StoreClient.api.getGameDetails(gameId)
                println(response)
                if (response.isSuccessful) {
                    val body = response.body()
                    gameResponse = body?.get(gameId)?.data
                    println("Fetched Successfully")
                } else {
                    errorMessage2 = "Failed to resolve game URL."
                    println("Failed to resolve game URL")
                }
                println(gameResponse)
//
//                val tagsResponse = RetrofitClient.api.getGameTags(apiKey, gameId)
//                if (tagsResponse.isSuccessful) {
//                    val tags = tagsResponse.body()
//
//                }
            } catch (e: Exception) {
                errorMessage = "Exception: ${e.message}"
            }
        }
    }
}
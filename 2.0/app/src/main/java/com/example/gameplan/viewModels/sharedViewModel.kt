package com.example.gameplan.viewModels

import RetrofitClient
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.gameplan.data.Player
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class SharedStateViewModel : ViewModel() {
    //Initial value is going to be a empty list. INTERNAL USE ONLY
    // Think of this as our "setter" for the friends list state
    private val _sharedFriendsList = MutableStateFlow(emptyList<Player>())

    // Our "getter" for our friends list. When you call SharedStateViewModel.updateSharedFriendsList,
    // your not updating this, therefore if _sharedFriendsList hasnt changed, neither wil this.
    val sharedFriendsList: StateFlow<List<Player>> = _sharedFriendsList.asStateFlow()

    private val _sharedCurrentPlayer = MutableStateFlow<Player?>(null)

    //This is how we updated our friends list. It takes a list of select players from the friend screen
    fun updateSharedFriendsList(newValue: List<Player>) {
        val tempList = newValue.toMutableList()
        _sharedCurrentPlayer.value?.let { currentPlayer ->
            tempList.add(currentPlayer)
            _sharedFriendsList.value = tempList
        } ?: run {
            Log.e("SharedStateViewModel", "Current player is null. Cannot update friends list.")
            // Optionally, handle the null scenario, e.g., initialize _sharedCurrentPlayer or show an error.
        }
    }




    suspend fun updatedCurrentPlayer(newValue: String) {
        val currentPlayerId = getCurrentUserId(newValue)
        if (currentPlayerId != null) {
            val player: Player? = setCurrentUser(currentPlayerId)
            if (player != null) {
                _sharedCurrentPlayer.value = player
            }
        }

    }
    // Private function
    // Returns provided users steamId

    private suspend fun getCurrentUserId(user: String): String? {
        try {
            val response = RetrofitClient.api.getSteamId("04E7A6580B01031C53C63E003B49425F", user)
            if (response.isSuccessful) {
                val vanityResponse = response.body()
                return if (vanityResponse != null && vanityResponse.response.success == 1) {
                    vanityResponse.response.steamid
                } else {
                    null
                }
            } else {
                return null
            }
        } catch (e: Exception) {
            return null
        }
    }
    // Private again. This receives the Player object for any provided steamid.

    private suspend fun setCurrentUser(userSteamId: String): Player? {
        try {
            val response =
                RetrofitClient.api.getPlayerSummary("04E7A6580B01031C53C63E003B49425F", userSteamId)
            return if (response.isSuccessful) {
                response.body()!!.playerSummaryResponse.players!![0]
            } else {
                null
            }
        } catch (e: Exception) {
            return null
        }

    }
}




package com.example.gameplan.viewmodel

import RetrofitClient
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameplan.data.FriendList
import com.example.gameplan.data.Player
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.gameplan.data.VanityResponse

class VanityViewModel : ViewModel() {

    var steamId by mutableStateOf<String?>(null)

    var errorMessage by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun fetchFromVanity(apiKey: String, username: String){
        viewModelScope.launch {
            isLoading = true;
            try {
                val response = RetrofitClient.api.getSteamId(apiKey, username)
                if (response.isSuccessful) {
                    val vanityResponse = response.body()
                    if (vanityResponse != null && vanityResponse.response.success == 1) {
                        steamId = vanityResponse.response.steamid
                        errorMessage = ""
                    } else {
                        errorMessage = "Failed to resolve vanity URL."
                        steamId = null
                    }
                }
            }catch (e: Exception) {
            errorMessage = "Exception: ${e.message}"
            steamId = null
        } finally {
            isLoading = false
        }

            }
        }
    }

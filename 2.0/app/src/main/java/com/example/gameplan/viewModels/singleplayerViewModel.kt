package com.example.gameplan.viewModels


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameplan.data.GameData
import kotlinx.coroutines.launch
import RetrofitClient
import StoreClient

class SingleplayerListViewModel : ViewModel() {

    private val apiKey = "04E7A6580B01031C53C63E003B49425F"

    private val _finalGames = MutableLiveData<List<GameData>>()
    val finalGames: LiveData<List<GameData>> get() = _finalGames

    fun getSingleplayerGames(apiKey: String, vanityUrl: String) {
        Log.d("fun", "getSingleplayerGames called $vanityUrl")
        viewModelScope.launch {
            try {
                // Step 1: Get Steam ID from Vanity URL
                val vanityResponse = RetrofitClient.api.getSteamId(apiKey, vanityUrl)
                val steamId = vanityResponse.body()?.response?.steamid ?: return@launch

                // Step 2: Get Owned Games using Steam ID
                val gamesResponse = RetrofitClient.api.getOwnedGames(apiKey, steamId)
                val ownedGames = gamesResponse.body()?.ownedGamesResponse?.games ?: return@launch


                val singleplayerGames = mutableListOf<GameData>()

                // Step 3: For each owned game, get game details and 0 playtime
                for (game in ownedGames.filter { it?.playtimeForever == 0 }.take(50)) {
                    Log.d("fun", "${game}")
                    val appId = game?.appid.toString()
                    val gameDetailsResponse = StoreClient.api.getGameDetails(appId)

                    val gameInfo = gameDetailsResponse.body()?.get(appId)?.data ?: continue

                        singleplayerGames.add(gameInfo)
                    }


                _finalGames.value = singleplayerGames

            } catch (e: Exception) {
                Log.e("SingleplayerViewModel", "Error fetching games", e)
            }
        }
    }
}

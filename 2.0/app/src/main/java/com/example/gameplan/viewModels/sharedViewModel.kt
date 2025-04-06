package com.example.gameplan.viewModels

import androidx.lifecycle.ViewModel
import com.example.gameplan.data.Player
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


// Any shared state between screens will be defined here.
class SharedStateViewModel : ViewModel() {
    private val _sharedFriendsList = MutableStateFlow(emptyList<Player>()) // Initial value is 0
    val sharedFriendsList: StateFlow<List<Player>> = _sharedFriendsList.asStateFlow()

    fun updateSharedFriendsList(newValue: List<Player>) {
        _sharedFriendsList.value = newValue
    }
}




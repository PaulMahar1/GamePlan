//package com.example.gameplan.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gameplan.components.BottomNav
import com.example.gameplan.components.FriendSquare
import com.example.gameplan.data.Player
import com.example.gameplan.ui.theme.screens.Routes
import com.example.gameplan.viewModels.SharedStateViewModel
import com.example.gameplan.viewmodel.FriendListViewModel

@Composable
fun FriendsScreen(
    navController: NavHostController,
    username: String,
    viewModel: FriendListViewModel = viewModel(),
    sharedViewModel: SharedStateViewModel
) {
    val friends = viewModel.friendNames
    val error = viewModel.errorMessage
    val selectedFriends = remember { mutableStateListOf<Player>() }

    LaunchedEffect(Unit) {
        viewModel.fetchFriendNames(
            apiKey = "04E7A6580B01031C53C63E003B49425F", username
        )
    }

    Scaffold(
        bottomBar = { BottomNav(navController) }
    ) { paddingValues: PaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            if (error.isNotEmpty()) {
                Text(text = error)
            }

            Button(onClick = {
                navController.navigate(Routes.GAMES_SCREEN)
            }) {
                Text("Go to Games")
            }

            LazyColumn(modifier = Modifier.weight(1f)) {
                items(friends) { friend ->
                    FriendSquare(
                        player = friend,
                        route = friend.profileurl,
                        navController = navController,
                        isSelected = selectedFriends.contains(friend),
                        onFriendSelected = { selected ->
                            if (selected) {
                                selectedFriends.add(friend)
                            } else {
                                selectedFriends.remove(friend)
                            }
                            sharedViewModel.updateSharedFriendsList(selectedFriends)
                        }
                    )
                }
            }
        }
    }
}

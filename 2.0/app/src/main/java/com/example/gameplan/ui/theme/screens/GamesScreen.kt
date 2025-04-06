package com.example.gameplan.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gameplan.components.BottomNav
import com.example.gameplan.components.FriendSquare
import com.example.gameplan.components.NavBar
import com.example.gameplan.data.Game
import com.example.gameplan.ui.theme.ShowGame
import com.example.gameplan.viewmodel.GameListViewModel
import com.example.gameplan.viewModels.SharedStateViewModel


@Composable
fun GamesScreen(navController: NavHostController, sharedViewModel: SharedStateViewModel = viewModel()) {
    val sharedFriendsList by sharedViewModel.sharedFriendsList.collectAsState()
    val viewModel: GameListViewModel = viewModel()

    println(sharedFriendsList)
    LaunchedEffect(sharedFriendsList) {
         viewModel.filterGames(sharedFriendsList)
    }

    var shownGames = viewModel.gamesList
    Log.d("Games Screen", "GamesScreen: $shownGames")
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            NavBar()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Use weight to fill remaining space
                    .padding(18.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {




                }
            }
            BottomNav(navController)
        }
    }


@Preview
@Composable
fun GamesScreenPreview() {
    GamesScreen(rememberNavController())
}


fun filterGames(){

}
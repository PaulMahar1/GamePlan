package com.example.gameplan.ui.theme.screens

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gameplan.BuildConfig.STEAM_API_KEY
import com.example.gameplan.components.BottomNav
import com.example.gameplan.components.FriendSquare
import com.example.gameplan.components.NavBar
import com.example.gameplan.ui.theme.ShowGame
import com.example.gameplan.viewmodel.GameListViewModel



@Composable
fun GamesScreen(navController: NavHostController, viewModel: GameListViewModel = viewModel()) {
    val shownGames = viewModel.gameResponse?.name

    LaunchedEffect(Unit) {
        viewModel.fetchGames("646570")
    }


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

if (shownGames != null) {
    println(shownGames)
}
//                        ShowGame(game = shownGames)


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
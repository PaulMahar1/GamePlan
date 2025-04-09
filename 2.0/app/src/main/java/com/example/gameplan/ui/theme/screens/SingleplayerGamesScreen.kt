package com.example.gameplan.ui.theme.screens

import DatabaseProvider
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gameplan.components.BottomNav
import com.example.gameplan.components.NavBar
import com.example.gameplan.data.GameData
import com.example.gameplan.data.database.GameEntity
import com.example.gameplan.ui.theme.ShowGame
import com.example.gameplan.viewModels.GameListViewModel
import com.example.gameplan.viewModels.SharedStateViewModel
import kotlinx.coroutines.delay

@Composable
fun SingleplayerGamesScreen(
    navController: NavHostController,
    sharedViewModel: SharedStateViewModel = viewModel()
) {
    val sharedFriendsList by sharedViewModel.sharedFriendsList.collectAsState()
    val viewModel: GameListViewModel = viewModel()
    var finalGames by remember { mutableStateOf<List<GameData?>>(emptyList()) }

    LaunchedEffect(sharedFriendsList) {
        delay(500)
        viewModel.filterGames(sharedFriendsList)
        delay(500)
        finalGames = viewModel.allDetails(viewModel.gamesList)
    }

    Log.d("Singleplayer Screen", "SingleplayerScreen: ${viewModel.gamesList}")
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            NavBar()
            // Wrap the content in a Box to center the loading indicator vertically/horizontally
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(18.dp),
                contentAlignment = Alignment.Center
            ) {
                if (finalGames.isEmpty()) {
                    CircularProgressIndicator()
                } else {
                    LazyColumn {
                        items(finalGames) { game ->
                            ShowGame(
                                game = game,
                                icon = Icons.Default.Star,
                                onClick = {
                                    // Offload database operation off the main thread
                                    Thread {
                                        val db = DatabaseProvider.getDatabase(context)
                                        val gameDao = db.gameDao()
                                        gameDao.upsertGame(
                                            GameEntity(
                                                gameId = game?.steamAppid,
                                                gameName = game?.name,
                                                gameImg = game?.headerImage,
                                                gameDesc = game?.shortDescription ?: "",
                                                gameGenres = game?.genres
                                            )
                                        )
                                    }.start()
                                }
                            )
                        }
                    }
                }
            }
            BottomNav(navController)
        }
    }
}

@Preview
@Composable
fun SingleplayerGamesScreenPreview() {
    SingleplayerGamesScreen(rememberNavController())
}

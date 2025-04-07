/*TODO
    Remove onclick add to db.
    only needed this for the game screen.
    this screen should only have the delete.
*/

package com.example.gameplan.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.example.gameplan.ui.theme.ShowSavedGame
import com.example.gameplan.viewmodel.GameListViewModel
import com.example.gameplan.viewModels.SharedStateViewModel

// With Delete
@Composable
fun SavedGamesScreen(
    navController: NavHostController,
    sharedViewModel: SharedStateViewModel = viewModel()
) {
    val sharedFriendsList by sharedViewModel.sharedFriendsList.collectAsState()
    val viewModel: GameListViewModel = viewModel()

    LaunchedEffect(sharedFriendsList) {
        viewModel.filterGames(sharedFriendsList)
    }

    // For demo purposes, we're creating a single game.
    val game = GameData(
        aboutTheGame = null,
        achievements = null,
        background = null,
        backgroundRaw = null,
        capsuleImage = null,
        capsuleImagev5 = null,
        categories = null,
        contentDescriptors = null,
        controllerSupport = null,
        detailedDescription = null,
        developers = listOf("Example Dev"),
        dlc = null,
        genres = null,
        headerImage = null,
        isFree = null,
        linuxRequirements = null,
        macRequirements = null,
        metacritic = null,
        movies = null,
        name = "Nathans Test Game",
        packageGroups = null,
        packages = null,
        pcRequirements = null,
        platforms = null,
        priceOverview = null,
        publishers = null,
        ratings = null,
        recommendations = null,
        releaseDate = null,
        requiredAge = null,
        reviews = null,
        screenshots = null,
        shortDescription = "meow",
        steamAppid = 69,
        supportInfo = null,
        supportedLanguages = null,
        type = null,
        website = null
    )

    val context = LocalContext.current
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            NavBar()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(18.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ShowSavedGame(
                    game = game,
                    onClick = {
                        // Your insert/upsert logic here
                        val db = DatabaseProvider.getDatabase(context)
                        val gameDao = db.gameDao()
                        Thread {
                            gameDao.upsertGame(
                                GameEntity(
                                    gameId = game.steamAppid,
                                    gameName = game.name,
                                    gameImg = "",
                                    gameDesc = game.shortDescription ?: ""
                                )
                            )
                        }.start()
                    },
                    onDelete = {
                        // Delete the game from the database
                        val db = DatabaseProvider.getDatabase(context)
                        val gameDao = db.gameDao()
                        Thread {
                            // Assuming you have a deleteGame function that takes the game ID:
                            gameDao.testdeleteGame(game.steamAppid)
                        }.start()
                    }
                )
            }
            BottomNav(navController)
        }
    }
}

//// No Delete
//@Composable
//fun SavedGamesScreen(
//    navController: NavHostController,
//    sharedViewModel: SharedStateViewModel = viewModel()
//) {
//    val sharedFriendsList by sharedViewModel.sharedFriendsList.collectAsState()
//    val viewModel: GameListViewModel = viewModel()
//
//    LaunchedEffect(sharedFriendsList) {
//        viewModel.filterGames(sharedFriendsList)
//    }
//
//    val shownGames = viewModel.gamesList
//    Log.d("Games Screen", "GamesScreen: $shownGames")
//    Surface(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Column(modifier = Modifier.fillMaxWidth()) {
//            NavBar()
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .weight(1f) // Use weight to fill remaining space
//                    .padding(18.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                val game = GameData(
//                    aboutTheGame = null,
//                    achievements = null,
//                    background = null,
//                    backgroundRaw = null,
//                    capsuleImage = null,
//                    capsuleImagev5 = null,
//                    categories = null,
//                    contentDescriptors = null,
//                    controllerSupport = null,
//                    detailedDescription = null,
//                    developers = listOf("Example Dev"),
//                    dlc = null,
//                    genres = null,
//                    headerImage = null,
//                    isFree = null,
//                    linuxRequirements = null,
//                    macRequirements = null,
//                    metacritic = null,
//                    movies = null,
//                    name = "Nathans Test Game",
//                    packageGroups = null,
//                    packages = null,
//                    pcRequirements = null,
//                    platforms = null,
//                    priceOverview = null,
//                    publishers = null,
//                    ratings = null,
//                    recommendations = null,
//                    releaseDate = null,
//                    requiredAge = null,
//                    reviews = null,
//                    screenshots = null,
//                    shortDescription = "meow",
//                    steamAppid = 69,
//                    supportInfo = null,
//                    supportedLanguages = null,
//                    type = null,
//                    website = null
//                )
//                val context = LocalContext.current
//                ShowGame(
//                    game = game,
//                    onClick = {
//                        val db = DatabaseProvider.getDatabase(context)
//                        val gameDao = db.gameDao()
//
//                        Thread {
//                            gameDao.upsertGame(
//                                GameEntity(
//                                    gameId = game.steamAppid,
//                                    gameName = game.name,
//                                    gameImg = "", // Set appropriately
//                                    gameDesc = game.shortDescription ?: ""
//                                )
//                            )
//                        }.start()
//                    }
//                )
//            }
//        }
//    }
//}

@Preview
@Composable
fun SavedGamesScreenPreview() {
    SavedGamesScreen(rememberNavController())
}

////Pauls previous work
//package com.example.gameplan.ui.theme.screens
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Surface
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//import com.example.gameplan.BuildConfig
//import com.example.gameplan.components.BottomNav
//import com.example.gameplan.components.NavBar
//import com.example.gameplan.ui.theme.ShowGame
//
////data class Game(val name: String, val age: Int)
//
//val apiKey = BuildConfig.STEAM_API_KEY
//
//@Composable
//fun SavedGamesScreen(navController: NavHostController) {
//    Surface(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Column(modifier = Modifier.fillMaxWidth()) {
//            NavBar()
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .weight(1f) // Use weight to fill remaining space
//                    .padding(18.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                // Fake list before real data
//                val games = listOf(
//                    Game("Alice", 25),
//                    Game("Charlie", 35),
//                    Game("Alice", 25),
//                    Game("Bob", 30),
//                    Game("Bob", 30),
//                    Game("Charlie", 35),
//                    Game("Alice", 25),
//                    Game("Bob", 30),
//                    Game("Charlie", 35)
//                )
//
//                LazyColumn {
//                    items(games) { game ->
//                        ShowGame(game)
//                    }
//                }
//            }
//            BottomNav(navController)
//        }
//    }
//}
//
//@Preview
//@Composable
//fun SavedGamesScreenPreview() {
//    SavedGamesScreen(rememberNavController())
//}
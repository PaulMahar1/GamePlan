/*TODO
    Need to figure out why this screen crashes
    Its identical to gameScreen, which leads me to
        believe its a weird routing issue
        See BottomNav.kt for more info
 */

package com.example.gameplan.ui.theme.screens

import DatabaseProvider
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gameplan.components.BottomNav
import com.example.gameplan.components.NavBar
import com.example.gameplan.data.GameData
import com.example.gameplan.data.database.GameEntity
import com.example.gameplan.ui.theme.ShowSavedGame


@Composable
fun SavedGamesScreen(
    navController: NavHostController,
//    sharedViewModel: SharedStateViewModel = viewModel()
) {
//    val sharedFriendsList by sharedViewModel.sharedFriendsList.collectAsState()
//    val viewModel: GameListViewModel = viewModel()
//
//    LaunchedEffect(sharedFriendsList) {
//        viewModel.filterGames(sharedFriendsList)
//    }

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

    val game2 = GameEntity(
        id = 134,
        gameId = 34544,
        gameName = "Pew Pew",
        gameImg = null,
        gameDesc = null
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
                    game = game2,

                    onDelete = {
                        val db = DatabaseProvider.getDatabase(context)
                        val gameDao = db.gameDao()
                        Thread {
                            gameDao.testdeleteGame(game.steamAppid)
                        }.start()
                    }
                )
            }
            BottomNav(navController)
        }
    }
}

@Preview
@Composable
fun SavedGamesScreenPreview() {
    SavedGamesScreen(rememberNavController())
}

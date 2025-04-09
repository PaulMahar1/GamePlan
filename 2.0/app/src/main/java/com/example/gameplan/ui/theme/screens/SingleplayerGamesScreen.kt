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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gameplan.components.BottomNav
import com.example.gameplan.components.NavBar
import com.example.gameplan.data.database.GameEntity
import com.example.gameplan.ui.theme.ShowGame
import com.example.gameplan.viewModels.SharedStateViewModel
import com.example.gameplan.viewModels.SingleplayerListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun SingleplayerGamesScreen(
    navController: NavHostController,
    username: String,
    viewModel: SingleplayerListViewModel = viewModel(),
    sharedViewModel: SharedStateViewModel
) {
    val finalGames by viewModel.finalGames.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.getSingleplayerGames(
            apiKey = "04E7A6580B01031C53C63E003B49425F",
            vanityUrl = username
        )
    }

    val context = LocalContext.current
    val viewModelScope = rememberCoroutineScope()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            NavBar("Your Games")
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

                                    viewModelScope.launch(Dispatchers.IO) {
                                        val db = DatabaseProvider.getDatabase(context)
                                        val gameDao = db.gameDao()
                                        gameDao.upsertGame(
                                            GameEntity(
                                                gameId = game.steamAppid,
                                                gameName = game.name,
                                                gameImg = game.headerImage,
                                                gameDesc = game.shortDescription ?: "",
                                                gameGenres = game.genres
                                            )
                                        )
                                    }
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
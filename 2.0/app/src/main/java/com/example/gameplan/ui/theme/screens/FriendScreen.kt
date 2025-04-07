/*
TODO
    EDIT - NEVERMIND THE STUFF I SAY BELOW VVV
    IDK WHAT I CHANGED BUT NOW I CAN CLICK FRIENDS AND IT WONT CRASH
    unless when u pull it breaks for you... idek anymore man :,)

TODO
    'Go to games'/GamesScreen has actually always been crashing.
    I went back through all my commits thinking I had done something that broke it.
    Went back to the last commit you did when you said it was working
        and it actually wasn't properly.
    To recreate a crash, relaunch app fresh, choose multiplayer, enter proper username,
        click any amount of friends, click 'go to games' = CRASH.
    To avoid a crash, you can either input an improper username, or dont select friends
        or load the GamesScreen through singleplayer first, any subsequent time you go
        to the gamesscreen until you reload the app it will open fine, but if you follow
        the crash steps, it crashes every time.
    This leads me to believe its just a functionality problem where when it actually tries
        to make the api call 'properly' it dies
*/

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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

            Button(
                onClick = { navController.navigate(Routes.GAMES_SCREEN) },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .align(Alignment.CenterHorizontally)
                    .height(48.dp)
            ) {
                Text("Go to Games")
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),               // 3 columns
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(4.dp)
            ) {
                items(friends.sortedBy { it.personaname }) { friend ->
                    FriendSquare(
                        player = friend,
                        route = friend.profileurl,
//                        navController = navController,
                        isSelected = selectedFriends.contains(friend),
                        onFriendSelected = { selected ->
                            if (selected) {
                                selectedFriends.add(friend)
                                sharedViewModel.updateSharedFriendsList(selectedFriends)
                            } else {
                                selectedFriends.remove(friend)
                                sharedViewModel.updateSharedFriendsList(selectedFriends)
                            }
                        }
                    )
                }
            }
        }
    }
}

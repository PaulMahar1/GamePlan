import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.navigation.compose.rememberNavController
import com.example.gameplan.components.BottomNav
import com.example.gameplan.components.FriendSquare
import com.example.gameplan.data.Player
import com.example.gameplan.ui.theme.screens.Routes
import com.example.gameplan.viewModels.FriendListViewModel
import com.example.gameplan.viewModels.SharedStateViewModel

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

    // Launch the API call when the composable is first composed.
    LaunchedEffect(Unit) {
        viewModel.fetchFriendNames(
            apiKey = "04E7A6580B01031C53C63E003B49425F",
            username
        )
    }

    Scaffold(
        bottomBar = { BottomNav(navController) }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // If the friends list is empty and there's no error, show a loading indicator.
            if (friends.isEmpty() && error.isEmpty()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                // Otherwise, show your friends grid.
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),  // 3 columns
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(bottom = 80.dp, top = 8.dp)
                ) {
                    items(friends.sortedBy { it.personaname }) { friend ->
                        FriendSquare(
                            player = friend,
                            route = friend.profileurl,
                            navController = navController,
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

                // The "Go to Games" button is locked above the bottomBar.
                Button(
                    onClick = { navController.navigate(Routes.GAMES_SCREEN) },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth(0.8f)
                        .height(48.dp)
                ) {
                    Text("Go to Games")
                }
            }
        }
    }
}


@Composable
fun FriendsScreenPreview() {
    FriendsScreen(
        navController = rememberNavController(),
        username = "PreviewUser",
        sharedViewModel = SharedStateViewModel()
    )
}
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gameplan.viewmodel.FriendListViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.gameplan.components.FriendSquare
import com.example.gameplan.data.Player
import com.example.gameplan.ui.theme.screens.Routes
import com.example.gameplan.viewModels.SharedStateViewModel


@Composable
fun FriendsScreen(navController: NavHostController, username: String, viewModel: FriendListViewModel = viewModel(),
                  sharedViewModel: SharedStateViewModel) {
    val friends = viewModel.friendNames
    Log.d("FriendsScreen", "Username received: $username")
    val error = viewModel.errorMessage
    var selectedFriends = remember { mutableStateListOf<Player>() }

    LaunchedEffect(Unit) {
        viewModel.fetchFriendNames(
            "04E7A6580B01031C53C63E003B49425F", username
        )
    }

    Column(modifier = Modifier.padding(16.dp)) {
        if (error.isNotEmpty()) {
            Text(text = error)
        }
        Button(onClick = {
            navController.navigate(Routes.GAMES_SCREEN)
        }) {
            Text("Go to Games")
        }

        LazyColumn {
            items(friends) { friend ->
                FriendSquare(
                    player = friend,
                    route = friend.profileurl,
                    navController = navController,
                    isSelected = selectedFriends.contains(friend), // Indicate selection state
                    onFriendSelected = { selected -> // Callback for selection changes
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


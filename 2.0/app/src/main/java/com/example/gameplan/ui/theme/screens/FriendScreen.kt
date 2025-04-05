import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gameplan.BuildConfig.STEAM_API_KEY
import com.example.gameplan.components.FriendSquare
import com.example.gameplan.ui.theme.screens.Routes
import com.example.gameplan.viewmodel.FriendListViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun FriendsScreen(navController: NavHostController, username: String, viewModel: FriendListViewModel = viewModel()) {
    val friends = viewModel.friendNames
    Log.d("FriendsScreen", "Username received: $username")
    val error = viewModel.errorMessage

    LaunchedEffect(Unit) {
        viewModel.fetchFriendNames(STEAM_API_KEY, username)
    }
    Column(modifier = Modifier.padding(16.dp)) {
        if (error.isNotEmpty()) {
            Text(text = error)
        }

        LazyColumn {
            items(friends) { friend ->
                FriendSquare(player = friend, route = Routes.GAMES_SCREEN, navController = navController)

            }
        }
    }
}

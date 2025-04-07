package com.example.gameplan.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.gameplan.data.Player

@Composable
fun FriendSquare(
    player: Player, route: String?,
    navController: NavHostController,
    isSelected: Boolean, // Indicate if the friend is selected
    onFriendSelected: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ElevatedCard(
            onClick = {
                onFriendSelected(!isSelected)
            },
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = Modifier
                .size(width = 100.dp, height = 100.dp)
        ) {

            AsyncImage(
                model = player.avatarmedium,
                modifier = Modifier
                    .fillMaxSize(),
                contentDescription = "$player's Avatar on Steam"
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = player.personaname!!,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}

//@Preview
//@Composable
//fun ShowFriendPreview(){
//    val navController = androidx.navigation.compose.rememberNavController()
//    FriendSquare(friend = Player(2012, "Friend", "Matty" ), Routes.GAMES_SCREEN, navController)
//}

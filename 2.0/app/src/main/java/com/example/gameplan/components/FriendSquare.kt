package com.example.gameplan.components

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.gameplan.data.Friend
import com.example.gameplan.data.Player


@Composable
fun FriendSquare(
    player: Player, route: String?,
    navController: NavHostController,
    isSelected: Boolean, // Indicate if the friend is selected
    onFriendSelected: (Boolean) -> Unit
) {

    ElevatedCard(
        onClick = { onFriendSelected(!isSelected)
                  },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),

        modifier = Modifier
            .size(width = 100.dp, height = 100.dp)){
        //IMAGE GOES HERE
        AsyncImage(
            model = player.avatarmedium,
            contentDescription = "Users Avatar on Steam"
        )
        Text(
            text = player.personaname!!,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )

//                Text(   CAN BE ADDED BACK IN FOR ADDITIONAL FRIEND DETAILS
//                    text = game.friendsSince.toString(),
//                    modifier = Modifier
//                        .padding(top = 6.dp,start = 16.dp),
//                    textAlign = TextAlign.Center,
//                )
    }
}
@Composable
fun TypeSquare(friend: Friend, onClick: () -> Unit) {
    ElevatedCard(
        onClick = { onClick() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 100.dp, height = 100.dp)){
        AsyncImage(
            model = friend.relationship,
            contentDescription = ""
        )
        Text(
            text = friend.steamid!!,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
//                Text(   CAN BE ADDED BACK IN FOR ADDITIONAL FRIEND DETAILS
//                    text = game.friendsSince.toString(),
//                    modifier = Modifier
//                        .padding(top = 6.dp,start = 16.dp),
//                    textAlign = TextAlign.Center,
//                )
    }
}



//@Preview
//@Composable
//fun ShowFriendPreview(){
//    val navController = androidx.navigation.compose.rememberNavController()
//    FriendSquare(friend = Player(2012, "Friend", "Matty" ), Routes.GAMES_SCREEN, navController)
//}

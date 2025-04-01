package com.example.gameplan.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gameplan.data.Friend
import com.example.gameplan.ui.theme.screens.Routes
import com.example.gameplan.data.FriendList

@Composable
fun FriendSquare(friend: Friend, route: String, navController: NavHostController) {
            ElevatedCard(
                onClick = {navController.navigate(route)},
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .size(width = 100.dp, height = 100.dp)){
                //IMAGE GOES HERE
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

@Composable
fun TypeSquare(friend: Friend, onClick: () -> Unit) {
    ElevatedCard(
        onClick = { onClick() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 100.dp, height = 100.dp)){
        //IMAGE GOES HERE
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



@Preview
@Composable
fun ShowFriendPreview(){
    val navController = androidx.navigation.compose.rememberNavController()
    FriendSquare(friend = Friend(2012, "Friend", "Matty" ), Routes.GAMES_SCREEN, navController)
}

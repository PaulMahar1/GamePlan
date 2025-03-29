package com.example.gameplan.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.gameplan.Friend
import com.example.gameplan.ui.theme.ShowGame
import com.example.gameplan.ui.theme.screens.FriendScreen
import com.example.gameplan.ui.theme.screens.Game

@Composable
fun FriendSquare(friend: Friend) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .size(width = 100.dp, height = 100.dp)){
                //IMAGE GOES HERE
                Text(
                    text = friend.steamid,
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
    FriendSquare(friend = Friend(2012, "Friend", "Matty" ))
}

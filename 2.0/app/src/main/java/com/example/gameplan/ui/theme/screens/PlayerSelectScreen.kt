package com.example.gameplan.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gameplan.Friend
import com.example.gameplan.components.BottomNav
import com.example.gameplan.components.FriendSquare
import com.example.gameplan.components.NavBar

@Composable
fun PlayerSelectScreen(navController: NavHostController){
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                NavBar()
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly) {
                        // FRIEND SQUARE NEEDS ROUTING ADDED SIMILAR TO HOW BOTTOM NAV BUTTONS DO IT
                        FriendSquare(friend = Friend(1, "Single", "Single Player"))
                        FriendSquare(friend = Friend(2, "Multi", "Multi Player"))

                    }
                    }
                BottomNav(navController)
                }
            }
        }

@Preview
@Composable
fun PlayerSelectScreenPreview(){
    PlayerSelectScreen(rememberNavController())
}


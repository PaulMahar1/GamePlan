package com.example.gameplan.ui.theme.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.gameplan.ui.theme.ShowGame

data class Game(val name: String, val age: Int)

@Composable
fun GamesScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(modifier = Modifier.fillMaxSize().padding(18.dp), horizontalAlignment = Alignment.CenterHorizontally) {
//            TopBar("Home Page")

            // Fake list before real data
            val games = listOf(
                Game("Alice", 25),
                Game("Bob", 30),
                Game("Charlie", 35),
                Game("Alice", 25),
                Game("Bob", 30),
                Game("Charlie", 35),
                Game("Alice", 25),
                Game("Bob", 30),
                Game("Charlie", 35)
            )

            LazyColumn {
                items(games) { game ->
                            ShowGame(game)
                }
            }
        }
    }
}

@Preview
@Composable
fun GamesScreen(){
    GamesScreen(rememberNavController())
}
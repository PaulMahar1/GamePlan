package com.example.gameplan.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gameplan.ui.theme.screens.Routes

@Composable
fun BottomNav(navController: NavHostController) {
    Column (
        modifier = Modifier.fillMaxWidth()
    ){ //COLUMN START
        Row(
            modifier = Modifier.height(56.dp)
                .fillMaxWidth()
                .background(color = Color.Cyan),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){ //ROW START
            NavButton(Icons.Filled.Home, "Home", Routes.WELCOME_SCREEN, navController)
            NavButton(Icons.Filled.PlayArrow, "Play", Routes.PLAYER_SELECT_SCREEN, navController)
            NavButton(Icons.Filled.Favorite, "Favorite", Routes.GAMES_SCREEN, navController)
        }
    }
}

@Preview
@Composable
fun BottomNavPreview(){
    val navController = androidx.navigation.compose.rememberNavController()
    BottomNav(navController)
}
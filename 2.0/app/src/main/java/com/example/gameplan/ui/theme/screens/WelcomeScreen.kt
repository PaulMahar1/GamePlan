package com.example.gameplan.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable fun WelcomeScreen(navController: NavHostController){
    Surface(
        modifier = Modifier.fillMaxSize().clickable{navController.navigate(Routes.PLAYER_SELECT_SCREEN)}
    ){
        Column(modifier = Modifier.fillMaxSize().padding(18.dp), horizontalAlignment = Alignment.CenterHorizontally) {

        }
    }
}
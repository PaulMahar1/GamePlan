package com.example.gameplan.ui.theme.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable fun WelcomeScreen(navController: NavHostController){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .clickable{navController.navigate(Routes.GAMES_SCREEN)}
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Hello World",
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable fun WelcomeScreenPreview(){
    WelcomeScreen(rememberNavController())
}
package com.example.gameplan.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gameplan.R

@Composable fun WelcomeScreen(navController: NavHostController){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .clickable{navController.navigate(Routes.GAMES_SCREEN)}
    ){
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
            contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.transparentlogo),
                contentDescription = "Logo",

            )
        }
    }
}

@Preview
@Composable fun WelcomeScreenPreview(){
    WelcomeScreen(rememberNavController())
}
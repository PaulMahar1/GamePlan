package com.example.gameplan.ui.theme.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gameplan.components.NavBar


@Composable
fun GamePlanNavigationGraph(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.WELCOME_SCREEN){

        composable(Routes.PLAYER_SELECT_SCREEN){
            PlayerSelectScreen(navController)
        }

        composable(Routes.WELCOME_SCREEN){
            WelcomeScreen(navController)
        }

        composable(Routes.TERMS_SCREEN){
            TermsScreen(navController)
        }

        composable(Routes.GAMES_SCREEN){
            GamesScreen(navController)
        }

        composable(Routes.FRIEND_SCREEN){
            FriendScreen(navController)
        }


    }
}


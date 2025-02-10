package com.example.gameplan.ui.theme.screens

import androidx.compose.runtime.Composable

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

        composable(Routes.GAMES_SCREEN){
            GamesScreen(navController)
        }
    }
}
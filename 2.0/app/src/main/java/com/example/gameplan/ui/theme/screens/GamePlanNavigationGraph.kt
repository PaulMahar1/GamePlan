package com.example.gameplan.ui.theme.screens


import FriendsScreen
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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

        composable(
            route = "FRIEND_SCREEN/{username}",
            arguments = listOf(navArgument("username") {
                type = NavType.StringType
            })
        ) { entry ->
            val username = entry.arguments?.getString("username")
            if (username != null) {
                FriendsScreen(navController = navController, username = username)
            } else {
                // Handle missing username, maybe navigate back
                Log.e("Navigation", "Username is missing!")
            }
        }

        composable(Routes.SAVED_GAMES_SCREEN){
            SavedGamesScreen(navController)
        }


    }
}


/*TODO
    Figure out why Favorite/Savedgamesscreen route is not working
        clicking on it insta crashes the app.
    I already tried making SavedGamesScreen the EXACT SAME as GamesScreen,
        so not sure why the code would work on GamesScreen but not SavedGamesScreen.
    I have an incling it has something to do with NavButton.kt
    "NavButton(Icons.Filled.Favorite, "Favorite", Routes.GAMES_SCREEN, navController)"
                                      --------------------------------
*/

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
fun BottomNav(navController: NavHostController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
                .background(color = Color.Cyan),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            NavButton(Icons.Filled.Home, "Home", Routes.WELCOME_SCREEN, navController)
            NavButton(Icons.Filled.PlayArrow, "Play", Routes.PLAYER_SELECT_SCREEN, navController)
            NavButton(Icons.Filled.Favorite, "Favorite", Routes.SAVED_GAMES_SCREEN, navController)
        }
    }
}

@Preview
@Composable
fun BottomNavPreview(){
    val navController = androidx.navigation.compose.rememberNavController()
    BottomNav(navController)
}
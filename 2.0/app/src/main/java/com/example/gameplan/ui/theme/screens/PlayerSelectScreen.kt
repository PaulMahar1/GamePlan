package com.example.gameplan.ui.theme.screens

import TypeSelectionDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gameplan.components.BottomNav
import com.example.gameplan.components.NavBar
import com.example.gameplan.components.TypeSquare
import com.example.gameplan.data.Friend


enum class GameMode { SinglePlayer, Multiplayer }

@Composable
fun PlayerSelectScreen(navController: NavHostController){
    var showDialog by remember { mutableStateOf(false) }
    var gameMode by remember { mutableStateOf<GameMode?>(null) }

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
                    Spacer(Modifier.height(250.dp))
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly) {
                        // FRIEND SQUARE NEEDS ROUTING ADDED SIMILAR TO HOW BOTTOM NAV BUTTONS DO IT
                        TypeSquare(friend = Friend(1, "Single", "Single Player"), onClick = { gameMode = GameMode.SinglePlayer
                            showDialog = true })
                        TypeSquare(friend = Friend(2, "Multi", "Multi Player"), onClick = { gameMode = GameMode.Multiplayer
                            showDialog = true })
                        }

                    }
                    if (showDialog && gameMode != null) {
                        TypeSelectionDialog(
                            gameMode = gameMode!!,
                            onDismiss = { showDialog = false },
                            onSubmit = { username ->
                                println("Username: $username | Mode: ${gameMode!!.name}")
                                // Handle different logic based on game mode
                                if (gameMode == GameMode.SinglePlayer){
                                    navController.navigate(Routes.GAMES_SCREEN)
                                } else {
                                    navController.navigate(Routes.FRIEND_SCREEN)
                                }
                                showDialog = false
                            }
                        )
                    }
                    }
            //MOVED TO TOP OF PAGE WHEN POPUP ADDED ???
                BottomNav(navController)
                }
            }


@Preview
@Composable
fun PlayerSelectScreenPreview(){
    PlayerSelectScreen(rememberNavController())
}


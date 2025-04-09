package com.example.gameplan.ui.theme.screens

import TypeSelectionDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gameplan.R
import com.example.gameplan.components.BottomNav
import com.example.gameplan.components.PlayerSelectSquare
import com.example.gameplan.viewModels.SharedStateViewModel
import kotlinx.coroutines.launch

enum class GameMode { SinglePlayer, Multiplayer }

@Composable
fun PlayerSelectScreen(
    navController: NavHostController,
    sharedStateViewModel: SharedStateViewModel
) {
    var showDialog by remember { mutableStateOf(false) }
    var gameMode by remember { mutableStateOf<GameMode?>(null) }
    val scope = rememberCoroutineScope()

    Scaffold(
//        topBar = { NavBar("Oh hey there") },
        bottomBar = { BottomNav(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.size(450.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.transparentlogo),
                    contentDescription = "Logo"
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                PlayerSelectSquare(
                    text = "Single Player",
                    painter = painterResource(id = R.drawable.singleplayerlogo)
                ) {
                    gameMode = GameMode.SinglePlayer
                    showDialog = true
                }

                PlayerSelectSquare(
                    text = "Multi Player",
                    painter = painterResource(id = R.drawable.multiplayerlogo)
                ) {
                    gameMode = GameMode.Multiplayer
                    showDialog = true
                }
            }

            if (showDialog && gameMode != null) {
                TypeSelectionDialog(
                    gameMode = gameMode!!,
                    onDismiss = { showDialog = false },
                    onSubmit = { username ->
                        scope.launch {
                            sharedStateViewModel.updatedCurrentPlayer(username)
                        }
                        if (gameMode == GameMode.SinglePlayer) {
                            // Navigate to the single player games screen
                            navController.navigate("SINGLEPLAYER_SCREEN/$username")
                        } else {
                            // Navigate to the friend selection screen (multiplayer)
                            navController.navigate("FRIEND_SCREEN/$username")
                        }
                        showDialog = false
                    }
                )
            }
        }
    }
}

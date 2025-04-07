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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gameplan.components.BottomNav
import com.example.gameplan.components.NavBar
import com.example.gameplan.components.TypeSquare
import com.example.gameplan.data.Friend
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
        topBar = { NavBar() },
        bottomBar = { BottomNav(navController) }
    ) { paddingValues: PaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(250.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TypeSquare(
                    friend = Friend(
                        1,
                        "https://img.icons8.com/?size=100&id=yl8D7ARqyYe3&format=png&color=000000",
                        "Single Player"
                    ),
                    onClick = {
                        gameMode = GameMode.SinglePlayer
                        showDialog = true
                    }
                )
                TypeSquare(
                    friend = Friend(
                        2,
                        "https://img.icons8.com/?size=100&id=JXxbQn0CKTqI&format=png&color=000000",
                        "Multi Player"
                    ),
                    onClick = {
                        gameMode = GameMode.Multiplayer
                        showDialog = true
                    }
                )
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
                            navController.navigate(Routes.GAMES_SCREEN)
                        } else {
                            navController.navigate("FRIEND_SCREEN/$username")
                        }
                        showDialog = false
                    }
                )
            }
        }
    }
}


//@Preview
//@Composable
//fun PlayerSelectScreenPreview() {
//    PlayerSelectScreen(rememberNavController(), sharedStateViewModel = /* Provide a view model instance */)
//}

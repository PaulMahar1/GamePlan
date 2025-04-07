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
fun PlayerSelectScreen(navController: NavHostController, sharedStateViewModel: SharedStateViewModel){
    var showDialog by remember { mutableStateOf(false) }
    var gameMode by remember { mutableStateOf<GameMode?>(null) }

    // The shared current user state is a suspend function, so we need top have a
    // coroutine scope for it to work in. This is a scope that is __local__ to PlayerSelectScreen
    // meaning have to do this in every composable you which to update the
    // current logged in user.
    val scope = rememberCoroutineScope()

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
                    TypeSquare(friend = Friend(1, "https://img.icons8.com/?size=100&id=yl8D7ARqyYe3&format=png&color=000000", "Single Player"), onClick = { gameMode = GameMode.SinglePlayer
                        showDialog = true })
                    TypeSquare(friend = Friend(2, "https://img.icons8.com/?size=100&id=JXxbQn0CKTqI&format=png&color=000000", "Multi Player"), onClick = { gameMode = GameMode.Multiplayer
                        showDialog = true })
                    }

                }
                if (showDialog && gameMode != null) {
                    TypeSelectionDialog(
                        gameMode = gameMode!!,
                        onDismiss = { showDialog = false },
                        onSubmit = { username ->
                            println("Username: $username | Mode: ${gameMode!!.name}")
                            // launch a new coroutine scope, update the new logged in user.
                            // May want to consider what will happen if the user doesn't exist.
                            // If we want to take it into consideration this scope launch
                            // to the very last place you can __before__ you swap screens so you know the username is
                            // correct.
                            scope.launch {
                                sharedStateViewModel.updatedCurrentPlayer(username)
                            }
                            // Handle different logic based on game mode
                            if (gameMode == GameMode.SinglePlayer){
                                navController.navigate(Routes.GAMES_SCREEN)
                            } else {
                                println(username)
                                navController.navigate("FRIEND_SCREEN/${username}")
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

//
//@Preview
//@Composable
//fun PlayerSelectScreenPreview(){
//    PlayerSelectScreen(rememberNavController())
//}
//

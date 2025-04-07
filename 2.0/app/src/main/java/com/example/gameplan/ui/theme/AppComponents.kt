package com.example.gameplan.ui.theme

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.gameplan.data.GameData

// GamesScreen
@Composable
fun ShowGame(game: GameData?, onClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ElevatedCard(
                onClick = onClick, // Using the onClick parameter of ElevatedCard (if available)
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                modifier = Modifier.size(width = 240.dp, height = 100.dp)
            ) {
                game?.let {
                    it.name?.let { name ->
                        Text(
                            text = name,
                            modifier = Modifier.padding(16.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                    it.shortDescription?.let { description ->
                        Text(
                            text = description,
                            modifier = Modifier.padding(top = 6.dp, start = 16.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

// SavedGamesScreen
@Composable
fun ShowSavedGame(
    game: GameData?,

    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = Modifier.size(width = 240.dp, height = 100.dp)
        ) {
            game?.let {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = it.name ?: "", textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = it.shortDescription ?: "", textAlign = TextAlign.Center)
                }
            }
        }
        // Delete button beside the game card
        Button(
            onClick = onDelete,
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text("Delete")
        }
    }
}

@Composable
fun JamieHtml(@StringRes stringResourceId: Int){
    Text(text = AnnotatedString.fromHtml(stringResource(id = stringResourceId)))
}



// meow
// woof >:3
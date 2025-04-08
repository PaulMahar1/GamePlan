package com.example.gameplan.ui.theme

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.gameplan.data.GameData
import com.example.gameplan.data.database.GameEntity

// GamesScreen
//@Composable
//fun ShowGame(game: GameData?, onClick: () -> Unit) {
//    Column(modifier = Modifier.fillMaxWidth()) {
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.Center
//        ) {
//            ElevatedCard(
//                onClick = onClick, // Using the onClick parameter of ElevatedCard (if available)
//                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
//                modifier = Modifier.size(width = 240.dp, height = 100.dp)
//            ) {
//                game?.let {
//                    it.name?.let { name ->
//                        Text(
//                            text = name,
//                            modifier = Modifier.padding(16.dp),
//                            textAlign = TextAlign.Center
//                        )
//                    }
//                    it.shortDescription?.let { description ->
//                        Text(
//                            text = description,
//                            modifier = Modifier.padding(top = 6.dp, start = 16.dp),
//                            textAlign = TextAlign.Center
//                        )
//                    }
//                }
//            }
//        }
//        Spacer(modifier = Modifier.height(16.dp))
//    }
//}

@Composable
fun ShowGame(game: GameData?, onClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ElevatedCard(
                onClick = onClick,
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                modifier = Modifier
                    .padding(8.dp) // Add padding to the card
                    .fillMaxWidth() // The card should take the full width
                    .height(150.dp) // You can adjust the height based on your preference
            ) {
                game?.let {
                    // Main Row inside the card for layout
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Game Image Section (you can load the image with Coil or other image loading libraries)
                        Image(
                            painter = rememberImagePainter(it.capsuleImage), // You can replace this with actual image URL from the data
                            contentDescription = it.name,
                            modifier = Modifier
                                .size(80.dp)
                                .padding(start = 16.dp) // Padding to the left of the image
                        )

                        // Game Info Section (Name, Description, etc.)
                        Column(
                            modifier = Modifier
                                .padding(start = 12.dp) // Space between image and text
                                .weight(1f) // This allows the text to take up the remaining space
                        ) {
                            // Game Name
                            it.name?.let { name ->
                                Text(
                                    text = name,
                                    style = MaterialTheme.typography.titleLarge,
                                    modifier = Modifier.padding(bottom = 4.dp),
                                    textAlign = TextAlign.Start
                                )
                            }

                            // Short Description
                            it.shortDescription?.let { description ->
                                Text(
                                    text = description,
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier.padding(top = 4.dp),
                                    textAlign = TextAlign.Start
                                )
                            }
                        }

                        // Add to DB Icon (Tiny Star Icon)
                        IconButton(
                            onClick = onClick,
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .align(Alignment.CenterVertically) // Align the icon in the middle vertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star, // You can replace with your own star icon or an image
                                contentDescription = "Add to DB",
                                modifier = Modifier.size(24.dp)
                            )
                        }
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
    game: GameEntity?,

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
                    Text(text = it.gameName ?: "", textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = it.gameDesc ?: "", textAlign = TextAlign.Center)
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
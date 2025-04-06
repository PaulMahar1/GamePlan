package com.example.gameplan.ui.theme

import android.text.Html
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gameplan.R
import com.example.gameplan.data.GameData

@Composable
fun ShowGame(game: GameData?){
    Column(
        modifier = Modifier
            .fillMaxWidth()){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center){
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .size(width = 240.dp, height = 100.dp)){
                if (game != null) {
                    game.name?.let {
                        Text(
                            text = it,
                            modifier = Modifier
                                .padding(16.dp),
                            textAlign = TextAlign.Center,
                        )
                    }
                }
                if (game != null) {
                    game.shortDescription?.let {
                        Text(
                            text = it,
                            modifier = Modifier
                                .padding(top = 6.dp,start = 16.dp),
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
    }
}


@Composable
fun JamieHtml(@StringRes stringResourceId: Int){
    Text(text = AnnotatedString.fromHtml(stringResource(id = stringResourceId)))
}



// meow
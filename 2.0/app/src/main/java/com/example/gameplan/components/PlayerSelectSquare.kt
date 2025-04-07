package com.example.gameplan.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun PlayerSelectSquare(
    text: String,
    painter: Painter,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ElevatedCard(
            onClick = onClick,
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = Modifier.size(150.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = "$text icon",
                modifier = Modifier
                    .fillMaxSize(),
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = text,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

package com.example.gameplan.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gameplan.ui.theme.Typography


@Composable
fun NavBar() {

        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.size(36.dp))
            Row(modifier = Modifier.fillMaxWidth()
                .background(color = Color.Cyan)
                .height(46.dp),
                verticalAlignment = Alignment.CenterVertically)
            {
                Text(modifier = Modifier.fillMaxWidth(),
                    text = "GamePlan",
                    textAlign = TextAlign.Center,
                    style = Typography.titleLarge


                )
            }
        }
    }

@Preview
@Composable
fun NavBarPreview(){
    NavBar()
}


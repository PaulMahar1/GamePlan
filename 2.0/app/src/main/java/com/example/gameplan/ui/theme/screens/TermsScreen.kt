package com.example.gameplan.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.pm.ShortcutInfoCompat.Surface
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gameplan.R
import com.example.gameplan.ui.theme.JamieHtml

@Composable
fun TermsScreen(navController: NavController){

    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            JamieHtml(R.string.Terms)
            Button(onClick = {navController.navigate(Routes.PLAYER_SELECT_SCREEN)}){
                Text(text = "Accept")
            }
        }
    }

}

@Preview
@Composable
fun TermsScreenPreview(){
    TermsScreen(rememberNavController())
}
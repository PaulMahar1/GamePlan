package com.example.gameplan.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.pm.ShortcutInfoCompat.Surface
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gameplan.R
import com.example.gameplan.ui.theme.HtmlText

@Composable
fun TermsScreen(navController: NavController){

    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp)
        ) { 
            HtmlText(R.string.Terms)

            
        }
    }

}

@Preview
@Composable
fun TermsScreenPreview(){
    TermsScreen(rememberNavController())
}
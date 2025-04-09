package com.example.gameplan.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gameplan.ui.theme.screens.Routes

@Composable
fun NavButton(iconIn: ImageVector, name: String, route: String, navController: NavHostController) {
    Box(modifier = Modifier.size(48.dp)) {
        IconButton(
            onClick = { navController.navigate(route) },
            modifier = Modifier.fillMaxSize(),
            enabled = true,
            colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White),
        ) {
            Icon(iconIn, contentDescription = name, modifier = Modifier.size(32.dp))
        }
    }
}

@Preview
@Composable
fun NavButtonPreview() {
    val navController = androidx.navigation.compose.rememberNavController()
    NavButton(Icons.Filled.Favorite, "Favorite", Routes.GAMES_SCREEN, navController)
}
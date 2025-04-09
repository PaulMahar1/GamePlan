package com.example.gameplan.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gameplan.R
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen(navController: NavHostController) {
    // Use a state variable to track whether navigation has already occurred.
    var navigated by remember { mutableStateOf(false) }

    // Automatically navigate after 3 seconds if not already done.
    LaunchedEffect(Unit) {
        delay(3000L)
        if (!navigated) {
            navigated = true
            navController.navigate(Routes.TERMS_SCREEN)
        }
    }

    // The Surface is clickable. If the user clicks before 3 seconds are up, navigate immediately.
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                if (!navigated) {
                    navigated = true
                    navController.navigate(Routes.TERMS_SCREEN)
                }
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.transparentlogo),
                contentDescription = "Logo",
            )
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(navController = rememberNavController())
}

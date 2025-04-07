package com.example.gameplan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.example.gameplan.ui.theme.GamePlanTheme
import com.example.gameplan.ui.theme.screens.GamePlanNavigationGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GamePlanTheme {
                GamePlanApp()
            }
        }
    }

    @Composable
    fun GamePlanApp() {
        GamePlanNavigationGraph()
    }

}


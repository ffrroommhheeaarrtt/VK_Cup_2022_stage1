package com.example.cup1.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.cup1.ui.screen.MainScreen
import com.example.cup1.ui.theme.Cup1Theme
import kotlinx.coroutines.delay

@Composable
fun App() {
    Cup1Theme {
        Surface(modifier = Modifier.fillMaxSize()) {
            var visible by remember { mutableStateOf(false) }

            LaunchedEffect(visible) {
                delay(300L)
                visible = true
            }

            MainScreen(visible = visible)
        }
    }
}
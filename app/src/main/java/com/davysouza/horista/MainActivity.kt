package com.davysouza.horista

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.davysouza.horista.ui.components.BottomBar
import com.davysouza.horista.ui.theme.HoristaTheme
import com.davysouza.horista.ui.view.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HoristaTheme {
                Scaffold(
                    bottomBar = { BottomBar() },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    HomeView(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
package com.example.charadas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.charadas.ui.navigation.AppNavGraph
import com.example.charadas.ui.theme.CharadasTheme
import com.example.charadas.viewmodel.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CharadasTheme {
                Surface {
                    val navController = rememberNavController()
                    val vm: GameViewModel = viewModel()
                    AppNavGraph(navController, vm)
                }
            }
        }
    }
}
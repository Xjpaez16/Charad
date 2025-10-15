package com.example.charadas.ui.result

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultScreen(
    score: Int,
    onRestart: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1565C0)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Puntuación",
                fontSize = 28.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$score",
                fontSize = 48.sp,
                color = Color(0xFF00E5FF),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = onRestart,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00E5FF)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Jugar de nuevo", color = Color.White, fontSize = 20.sp)
            }
        }
    }
}
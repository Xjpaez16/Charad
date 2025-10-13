package com.example.charadas.ui.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    GameScreen(
        word = "Charada",
        timeLeft = 30,
        score = 5,
        onCorrect = {},
        onPass = {},
        onTimeOut = {}
    )
}

@Composable
fun GameScreen(
    word: String,
    timeLeft: Int,
    score: Int,
    onCorrect: () -> Unit,
    onPass: () -> Unit,
    onTimeOut: () -> Unit
) {
    LaunchedEffect(timeLeft) {
        if (timeLeft == 0) onTimeOut()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1565C0))
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight()
        ) {
            Text(
                text = "$timeLeft",
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = word,
                    fontSize = 48.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    lineHeight = 56.sp
                )
            }

            Text(
                text = "Puntuación: $score",
                fontSize = 22.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = onPass,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA000)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.width(140.dp)
                ) {
                    Text("Pasar", color = Color.White, fontSize = 18.sp)
                }
                Button(
                    onClick = onCorrect,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF43A047)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.width(140.dp)
                ) {
                    Text("Correcto", color = Color.White, fontSize = 18.sp)
                }
            }
        }
    }
}

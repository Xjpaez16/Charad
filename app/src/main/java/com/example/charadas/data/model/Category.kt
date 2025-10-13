package com.example.charadas.data.model
import androidx.compose.ui.graphics.Color

data class Category(
    val name: String,
    val emoji: String,
    val color: Color,
    val words: List<String>
)
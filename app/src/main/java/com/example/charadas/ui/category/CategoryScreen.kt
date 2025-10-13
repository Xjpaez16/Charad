package com.example.charadas.ui.category

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.charadas.data.model.Category

import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun CategoryScreenPreview() {
    val sampleCategories = listOf(
        Category(name = "Animales", emoji = "🐶", color = Color(0xFF4CAF50), words = emptyList()),
        Category(name = "Películas", emoji = "🎬", color = Color(0xFF2196F3), words = emptyList()),
        Category(name = "Comida", emoji = "🍕", color = Color(0xFFFF9800), words = emptyList()),
        Category(name = "Deportes", emoji = "⚽", color = Color(0xFFF44336), words = emptyList())
    )

    CategoryScreen(
        categories = sampleCategories,
        onCategorySelected = {}
    )
}


@Composable
fun CategoryScreen(
    categories: List<Category>,
    onCategorySelected: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Elige una categoría",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Cuadrícula de categorías (2 por fila)
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            categories.chunked(2).forEach { rowCategories ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()

                ) {
                    rowCategories.forEach { category ->
                        CategoryCard(
                            category = category,
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1.1f)
                                .clickable { onCategorySelected(category.name) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryCard(category: Category, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        color = category.color,
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(category.color),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = category.emoji,
                fontSize = 48.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                textAlign = TextAlign.Center,
                text = category.name,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp


            )
        }
    }
}

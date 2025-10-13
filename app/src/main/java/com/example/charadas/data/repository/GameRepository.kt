package com.example.charadas.data.repository

import androidx.compose.ui.graphics.Color
import com.example.charadas.data.model.Category

class GameRepository {

    val categories = listOf(
        Category(
            name = "Acciones",
            emoji = "🏃‍♂️",
            color = Color(0xFF26C6DA),
            words = listOf(
                "Saltar", "Correr", "Comer", "Dormir", "Llorar", "Reír", "Bailar", "Nadar",
                "Cantar", "Volar", "Caminar", "Mirar", "Jugar", "Limpiar", "Cocinar",
                "Beber", "Trabajar", "Escribir", "Leer", "Pintar"
            )
        ),
        Category(
            name = "Animales",
            emoji = "🦁",
            color = Color(0xFF2196F3),
            words = listOf(
                "Perro", "Gato", "León", "Tigre", "Elefante", "Pájaro", "Pez", "Rana",
                "Oso", "Mono", "Vaca", "Cerdo", "Conejo", "Lobo", "Cebra", "Camello",
                "Jirafa", "Loro", "Pingüino", "Búho"
            )
        ),
        Category(
            name = "Objetos",
            emoji = "📦",
            color = Color(0xFFFFC107),
            words = listOf(
                "Teléfono", "Libro", "Lámpara", "Bicicleta", "Reloj", "Televisor",
                "Mochila", "Silla", "Mesa", "Llaves", "Bolígrafo", "Gafas",
                "Zapatos", "Sombrero", "Paraguas", "Cepillo", "Taza", "Botella",
                "Almohada", "Cama"
            )
        ),
        Category(
            name = "Películas",
            emoji = "🎬",
            color = Color(0xFF9C27B0),
            words = listOf(
                "Titanic", "Frozen", "Avatar", "El Rey León", "Harry Potter", "Toy Story",
                "Jurassic Park", "Coco", "Matrix", "Star Wars", "Shrek", "El Hobbit",
                "Buscando a Nemo", "Los Vengadores", "La Bella y la Bestia", "Jumanji",
                "El Origen", "La La Land", "Mad Max", "El Padrino"
            )
        ),
        Category(
            name = "Deportes",
            emoji = "🏀",
            color = Color(0xFF4CAF50),
            words = listOf(
                "Fútbol", "Baloncesto", "Tenis", "Natación", "Atletismo", "Boxeo",
                "Rugby", "Voleibol", "Golf", "Ciclismo", "Esquí", "Gimnasia",
                "Surf", "Karate", "Skateboard", "Baseball", "Hockey", "Taekwondo",
                "Béisbol", "Paracaidismo"
            )
        ),
        Category(
            name = "Series",
            emoji = "📺",
            color = Color(0xFFFF7043),
            words = listOf(
                "Friends", "Stranger Things", "La Casa de Papel", "Breaking Bad",
                "Game of Thrones", "The Office", "The Simpsons", "Lost", "The Mandalorian",
                "Westworld", "Grey’s Anatomy", "Narcos", "The Crown", "Sherlock",
                "House of Cards", "Black Mirror", "Vikings", "How I Met Your Mother",
                "Dexter", "Peaky Blinders"
            )
        )
    )

    fun getCategoryByName(name: String): Category?  {
        return categories.find { it.name == name }// We use .find to return the first element that matches the condition
    }
}

package com.example.charadas.ui.navigation

// jetpack compose navigation, routes and screens
// sealed class is used for navigation because the sealed class can have different objects with the same parent class
sealed class NavRoutes(val route: String) {
    object Category : NavRoutes("category_screen") //in this case the object is Category ,it´s heredity by NavRoutes
    object Game : NavRoutes("game_screen")
    object Result : NavRoutes("result_screen")
}
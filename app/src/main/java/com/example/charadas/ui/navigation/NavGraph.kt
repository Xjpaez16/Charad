package com.example.charadas.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.charadas.ui.category.CategoryScreen
import com.example.charadas.ui.game.GameScreen
import com.example.charadas.ui.result.ResultScreen
import com.example.charadas.viewmodel.GameViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController,
    vm: GameViewModel
) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Category.route //Here we define the first screen that will be displayed
    ) {
        composable(NavRoutes.Category.route) {
            CategoryScreen(
                categories = vm.categories,
                onCategorySelected = {
                    vm.startGame(it)
                    navController.navigate(NavRoutes.Game.route)
                }
            )
        }

        composable(NavRoutes.Game.route) {
            GameScreen(
                word = vm.currentWord.value,
                timeLeft = vm.timeLeft.value,
                score = vm.score.value,
                onCorrect = vm::correct, //Here we call the correct function from the viewmodel (the operator ::(double colon) is used to pass the function as an argument)
                onPass = vm::pass,
                onTimeOut = {
                    vm.finishGame()
                    navController.navigate(NavRoutes.Result.route)
                }
            )
        }

        composable(NavRoutes.Result.route) {
            ResultScreen(
                score = vm.score.value,
                onRestart = {
                    navController.navigate(NavRoutes.Category.route) {
                        popUpTo(NavRoutes.Category.route) { inclusive = true }//Here we remove the previous screens from the backstack, so we can't go back to the previous screen
                    }
                }
            )
        }
    }
}
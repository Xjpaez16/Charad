package com.example.charadas.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.charadas.data.repository.GameRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {

    private val repository = GameRepository()
    val categories = repository.categories
    //mutableStateOf make a variable observable, so we can update it in the UI
    val selectedCategory = mutableStateOf<String?>(null)
    val currentWord = mutableStateOf("")
    val score = mutableStateOf(0)//We used mutableStateOf because we want to update the score in the UI
    val timeLeft = mutableStateOf(60)

    private var unusedWords = mutableListOf<String>()
    private var timerJob: Job? = null //The job is like a remote control, we used to cancel it when we want to stop the timer


    fun startGame(category: String) {
        selectedCategory.value = category
        score.value = 0
        timeLeft.value = 60
        //Here we call the function to get the name of category
        unusedWords = repository.getCategoryByName(category)?.words?.shuffled()?.toMutableList() ?: mutableListOf()
        //if the callback is not null ,it  call the argument.word of Category Object
        //if the callback is not null  ,it call .shuffled to randomize the order of the words
        //if the callback is not null  ,it convert to mutableList because we want to modify it
        nextWord()
        startTimer()
    }

    private fun startTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            for (i in 60 downTo 0) {
                timeLeft.value = i
                delay(1000)
                if (i == 0) {
                    finishGame()
                }
            }
        }
    }

    private fun nextWord() {
        if (unusedWords.isNotEmpty()) {
            currentWord.value = unusedWords.removeAt(0) //we remove the current word
        } else {
            currentWord.value = "¡Sin más palabras!"
            finishGame()
        }
    }

    fun correct() {
        score.value++
        nextWord()
    }

    fun pass() {
        nextWord()
    }

    fun finishGame() {
        timerJob?.cancel()
        timeLeft.value = 0
    }
}

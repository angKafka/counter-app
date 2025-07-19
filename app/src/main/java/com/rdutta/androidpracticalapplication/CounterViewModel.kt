package com.rdutta.androidpracticalapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class CounterViewModel : ViewModel() {
    var timerStart by mutableStateOf(0)
        private set

    var isRunning by mutableStateOf(false)
        private set

    fun startTimer() {
        if (isRunning) return // Avoid multiple timers
        isRunning = true

        viewModelScope.launch {
            while (isRunning) {
                delay(100) // 1 second delay
                timerStart += 1
                println("Timer: $timerStart")
            }
        }
    }

    fun resetTimer() {
        isRunning = false
        timerStart = 0
        println("Timer reset.")
    }

    fun stopTimer() {
        isRunning = false
        println("Timer stopped at: $timerStart")
    }
}
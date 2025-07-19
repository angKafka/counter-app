package com.rdutta.androidpracticalapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class ContactsViewModel : ViewModel() {
    var backgroundColor by mutableStateOf(Color.White)
        private set

    var textColor by mutableStateOf(Color.Black)
        private set

    fun changeColors() {
        backgroundColor = Color.Black
        textColor = Color.White
    }
}
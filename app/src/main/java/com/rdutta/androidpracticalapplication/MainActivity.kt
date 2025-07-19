package com.rdutta.androidpracticalapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rdutta.androidpracticalapplication.ui.theme.AppTheme


class MainActivity : ComponentActivity() {
    val viewModel by viewModels<CounterViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                TimerScreen(viewModel = viewModel)
            }
        }
        println("Created the activity.")
    }

    override fun onStart() {
        super.onStart()
        println("Starting the activity.")
    }

    override fun onResume() {
        super.onResume()
        println("Resumed the activity.")
    }

    override fun onPause() {
        super.onPause()
        println("Paused the activity.")
    }

    override fun onStop() {
        super.onStop()
        println("Stopped the activity.")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("App closed - Destroyed the activity.")
    }
}


@Composable
fun TimerScreen(viewModel: CounterViewModel) {
    val timer = viewModel.timerStart
    val dynamicFontSize = when (timer.toString().length) {
        1 -> 250.sp
        2 -> 130.sp
        3 -> 100.sp
        4 -> 80.sp
        else -> 60.sp
    }

    Column(
        modifier = Modifier
            .padding(WindowInsets.statusBars.asPaddingValues())
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Header
        Text(
            text = "Sprint App",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(top = 32.dp)
        )

        // Center Timer
        if(timer == 0){
            Text(
                text = "$timer",
                style = MaterialTheme.typography.displayLarge,
                fontSize = dynamicFontSize,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.4f),
                modifier = Modifier.padding(16.dp)
            )
        }else{
            Text(
                text = "$timer",
                style = MaterialTheme.typography.displayLarge,
                fontSize = dynamicFontSize,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.89f),
                modifier = Modifier.padding(16.dp)
            )
        }

        // Buttons at the Bottom
        Row(
            modifier = Modifier
                .padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { viewModel.startTimer() },
                modifier = Modifier.weight(1f)
            ) {
                Text("Start")
            }

            Button(
                onClick = { viewModel.stopTimer() },
                modifier = Modifier.weight(1f)
            ) {
                Text("Stop")
            }

            Button(
                onClick = { viewModel.resetTimer() },
                modifier = Modifier.weight(1f)
            ) {
                Text("Reset")
            }
        }
    }
}
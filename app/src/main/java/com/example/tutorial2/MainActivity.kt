package com.example.tutorial2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.tutorial2.ui.theme.Tutorial2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val questions = List(1000) { "question $it" } // Creates list of 100 questions
        setContent {
            Tutorial2Theme {
                // Toggle between the two functions to compare
                //LazyColumn(questions) // Uncomment to use LazyColumn
                Column(questions) // Currently using ColumnDisplay
            }
        }
    }
}
//LazyColumn
@Composable
fun LazyColumn(questions: List<String>) {
    // Record the start time for performance measurement
    val startTime = System.currentTimeMillis()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        // Iterate through the questions list and render each item
        items(questions) { question ->
            // Row composable to display each question
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = question, fontSize = 16.sp)
            }
        }
    }
    // LaunchedEffect to log the time taken for composition
    LaunchedEffect(Unit) {
        val endTime = System.currentTimeMillis()
        Log.d("PERF_TEST", "LazyColumn composition ${endTime - startTime} ms")
    }
}

// Column
@Composable
fun Column(questions: List<String>) {
    // Record the start time for performance measurement, using remember to persist across recompositions
    val startTime = remember { System.currentTimeMillis() }
    // Create a scroll state for the Column
    val scrollState = rememberScrollState()
    // Column composable with vertical scrolling enabled
    Column(
        modifier = Modifier
            .fillMaxSize() // Fill the entire available space
            .verticalScroll(scrollState) // Enable vertical scrolling
    ) {
        // Iterate through the questions list and render each item
        questions.forEach { question ->
            // Row composable to display each question
            Row(modifier = Modifier.fillMaxWidth()) {
                // Display the question text with a font size of 16sp
                Text(text = question, fontSize = 16.sp)
            }
        }
    }
    // LaunchedEffect to log the time taken for composition
    LaunchedEffect(Unit) {
        // Calculate and log the time difference for performance tracking
        val endTime = System.currentTimeMillis()
        Log.d("PERF_TEST", "Column composition ${endTime - startTime} ms")
    }
}


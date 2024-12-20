package com.example.navigationapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScreenTwo(user: String?, age: Int?, onNavigateBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = when {
                user.isNullOrEmpty() -> "Hello, Guest!"
                age == null || age <= 0 -> "Hello, $user!"
                else -> "Hello, $user! You are $age years old."
            },
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = onNavigateBack) {
            Text(text = "Back to First Page")
        }
    }
}

@Preview
@Composable
fun SecondPreview() {
    ScreenTwo(user = "Preview", age = 25, onNavigateBack = {})
}
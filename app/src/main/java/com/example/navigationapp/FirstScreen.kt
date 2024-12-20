package com.example.navigationapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ScreenOne(onNavigateToSecond: (String, Int) -> Unit) {
    var username by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to the First Page", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Enter your name") }
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Enter your age") },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = {
                val parsedAge = age.toIntOrNull() ?: 0 // Обработка ошибок: если не число, то 0
                onNavigateToSecond(username, parsedAge)
            }
        ) {
            Text(text = "Proceed to Second Page")
        }
    }
}

@Preview
@Composable
fun FirstPreview() {
    ScreenOne(onNavigateToSecond = { _, _ -> })
}
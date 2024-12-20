package com.example.navigationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigator()
        }
    }
}

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "screen_one") {
        composable("screen_one") {
            ScreenOne { name, age ->
                navController.navigate("screen_two/$name/$age")
            }
        }
        composable("screen_two/{name}/{age}") { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("name")
            val userAge = backStackEntry.arguments?.getString("age")?.toIntOrNull()
            ScreenTwo(user = userName, age = userAge) {
                navController.popBackStack()
            }
        }
    }
}
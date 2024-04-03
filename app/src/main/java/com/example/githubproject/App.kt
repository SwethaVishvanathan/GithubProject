package com.example.githubproject
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun App() {
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "UserScreen"){
        composable("UserScreen"){
            navController.navigate("SwethaVishvanathan")
        }
        composable("RepositoryListScreen1"){
            navController.navigate("SwethaVishvanathan")
        }
        composable("RepositoryListScreen2"){
            navController.navigate("SwethaVishvanathan")
        }
        composable("RepositorySearchScreen"){
            navController.navigate("search")
        }
    }
}
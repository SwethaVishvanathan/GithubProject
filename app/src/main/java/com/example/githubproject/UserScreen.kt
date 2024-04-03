package com.example.githubproject

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(username: String): String {
    var user by remember { mutableStateOf<User?>(null) }
    val retrofit = remember {
        Retrofit.Builder()
            .baseUrl("https://github.com/SwethaVishvanathan/Github.git")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiService = retrofit.create(APIService::class.java)

    LaunchedEffect(Unit) {
        val response = apiService.getUser(username)
        user = response
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "GitHub User") }
            )
        },
        content = {
            if (user != null) {
                UserContent(user!!)
            } else {
                CircularProgressIndicator(modifier = Modifier.padding(16.dp))
            }
        }
    )
    return TODO("Provide the return value")
}

@Composable
fun UserContent(user: User) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Username: ${user.username}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "ID: ${user.id}")
        Spacer(modifier = Modifier.height(8.dp))
        // Load and display user avatar
        // You can use Coil, Glide, or any other image loading library here
        // Example:
        // Image(
        //     painter = rememberImagePainter(user.avatarUrl),
        //     contentDescription = null,
        //     modifier = Modifier.size(100.dp)
        // )
    }
}
package com.example.githubproject
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.compose.ui.unit.dp
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepositorySearchScreen(query: String) {
    var repositories by remember { mutableStateOf<List<Repository>>(emptyList()) }
    val retrofit = remember {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiService = retrofit.create(APIService::class.java)

    LaunchedEffect(query) {
        val response = apiService.searchRepositories(query)
        repositories = response.items
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Repository Search") }
            )
        },
        content = {
            if (repositories.isNotEmpty()) {
                RepositoryList(repositories)
            } else {
                CircularProgressIndicator(modifier = Modifier.padding(16.dp))
            }
        }
    )
}
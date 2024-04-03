package com.example.githubproject
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun RepositoryList(repositories: List<Repository>) {
    LazyColumn {
        items(repositories) { repository ->
            RepositoryItem(repository)
        }
    }
}



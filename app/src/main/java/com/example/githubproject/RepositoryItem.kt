package com.example.githubproject
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@Composable
fun RepositoryItem(repository: Repository) {
    Text(
        text = repository.name,
        modifier = Modifier.padding(16.dp)
    )
}
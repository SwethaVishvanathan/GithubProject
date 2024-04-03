package com.example.githubproject

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun RepositoryListScreen2(repositoryRepository: RepositoryRepository) {
    var repositories by remember { mutableStateOf<List<Repository>>(emptyList()) }
    LaunchedEffect(Unit) {
        repositories =repositoryRepository.getCachedRepositories()
        if (repositories.isEmpty()) {
            repositoryRepository.fetchAndCacheRepositories()
            repositories = repositoryRepository.getCachedRepositories()
        }
    }
    // Display repositories in UI
}
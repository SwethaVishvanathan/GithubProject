package com.example.githubproject

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryRepository(private val apiService: APIService, private val database: AppDatabase) {
    suspend fun fetchAndCacheRepositories() {
        val repositories = apiService.searchRepositories("jetpack compose").items
        withContext(Dispatchers.IO) {
            database.repositoryDao().insertRepositories(repositories)
        }
    }

    suspend fun getCachedRepositories(): List<Repository> {
        return withContext(Dispatchers.IO) {
            database.repositoryDao().getAllRepositories()
        }
    }
}
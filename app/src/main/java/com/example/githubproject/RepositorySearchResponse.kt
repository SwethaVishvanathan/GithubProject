package com.example.githubproject
data class RepositorySearchResponse(
    val total_count: Int,
    val items: List<Repository>
)

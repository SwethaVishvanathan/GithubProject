package com.example.githubproject
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
interface APIService {
    @GET("users/{SwethaVishvanathan}")
    suspend fun getUser(@Path("SwethaVishvanathan")username:String):User
    @GET("users")
    suspend fun searchUsers(@Query("q") query: String):List<User>
    @GET("users/{SwethaVishvanathan}/repos")
    suspend fun getUserRepositories(@Path("SwethaVishvanathan") username: String): List<Repository>
    @GET("search/repositories")
    suspend fun searchRepositories(@Query("q") query: String): RepositorySearchResponse
    @GET("users/{SwethaVishvanathan}/repos")
    suspend fun searchUserRepositories(
        @Path("SwethaVishvanathan") name: String,
        @Query("q") query: String
    ): List<Repository>
}
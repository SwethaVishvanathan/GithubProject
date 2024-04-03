package com.example.githubproject

import com.google.gson.annotations.SerializedName
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "repositories")
data class Repository(
    @PrimaryKey val id: Int,
    val name: String,
    @SerializedName("html_url") val htmlUrl: String
)


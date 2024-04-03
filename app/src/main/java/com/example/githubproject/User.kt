package com.example.githubproject

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login") val username:String,
    val id:Int,
    @SerializedName("av_url") val avUrl:String
)

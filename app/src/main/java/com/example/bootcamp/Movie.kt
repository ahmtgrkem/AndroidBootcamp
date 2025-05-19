package com.example.bootcamp // Kendi paket adınızla değiştirin

data class Movie(
    val id: Int,
    val title: String,
    val posterUrl: String,
    val bannerUrl: String? = null,
    val description: String? = null,
    val posterResId: Int
)


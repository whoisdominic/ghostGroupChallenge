package com.ngmatt.weedmapsandroidcodechallenge.models

data class ReviewObject(
    val possible_languages: List<String>,
    val reviews: List<Review>,
    val total: Int
)
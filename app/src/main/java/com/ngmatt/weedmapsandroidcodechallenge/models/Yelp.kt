package com.ngmatt.weedmapsandroidcodechallenge.models

data class Yelp(
    val businesses: List<Business>,
    val region: Region,
    val total: Int
)
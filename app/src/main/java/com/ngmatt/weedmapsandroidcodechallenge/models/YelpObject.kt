package com.ngmatt.weedmapsandroidcodechallenge.models

data class YelpObject(
    val businesses: List<Business>,
    val region: Region,
    val total: Int
)
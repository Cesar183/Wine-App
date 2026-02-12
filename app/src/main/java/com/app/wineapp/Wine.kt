package com.app.wineapp

data class Wine(
    val winery: String,
    val wine: String,
    val rating: Rating,
    val location: String,
    val image: String,
    val id: Int
)

data class Rating(
    val average: String,
    val reviews: String
)
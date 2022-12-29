package com.kadirkuruca.newsapp.data.model
//class data
data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)
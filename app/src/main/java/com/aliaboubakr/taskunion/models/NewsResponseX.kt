package com.aliaboubakr.taskunion.models

data class NewsResponseX(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)
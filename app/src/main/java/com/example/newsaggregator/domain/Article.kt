package com.example.newsaggregator.domain

data class Article(
    val title: String,
    val link: String,
    val pubDate: String?,
    val guid: String?
)
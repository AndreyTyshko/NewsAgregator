package com.example.newsaggregator.data.rss

import com.example.newsaggregator.data.rss.dto.ArticleDto
import com.example.newsaggregator.domain.Article

fun ArticleDto.toDomain(): Article {
    return Article(title, link, pubDate, guid)
}
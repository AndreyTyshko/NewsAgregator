package com.example.newsaggregator.data.rss

import com.example.newsaggregator.domain.Article

interface ArticleRepository {
    suspend fun getArticles(): List<Article>
}
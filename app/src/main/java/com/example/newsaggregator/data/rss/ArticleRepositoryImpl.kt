package com.example.newsaggregator.data.rss

import com.example.newsaggregator.domain.Article
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val rssFeed: RssFeed
) : ArticleRepository {
    override suspend fun getArticles(): List<Article> {
        return rssFeed.getRss().channel?.items?.map { it.toDomain() } ?: emptyList()
    }
}
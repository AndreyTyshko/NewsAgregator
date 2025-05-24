package com.example.newsaggregator.data.rss


import com.example.newsaggregator.domain.Article
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val repository: ArticleRepository,

) {
    suspend operator fun invoke(): List<Article> = repository.getArticles()
}
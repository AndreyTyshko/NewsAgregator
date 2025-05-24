package com.example.newsaggregator.data.rss.dto

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item", strict = false)
data class ArticleDto(
    @field:Element(name = "title") var title: String = "",
    @field:Element(name = "link") var link: String = "",
    @field:Element(name = "pubDate", required = false) var pubDate: String? = null,
    @field:Element(name = "guid", required = false) var guid: String? = null
)


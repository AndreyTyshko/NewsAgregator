package com.example.newsaggregator.data.rss.dto

import ChannelDto
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class RssDto(
    @field:Element(name = "channel")
    var channel: ChannelDto
)
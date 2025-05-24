import com.example.newsaggregator.data.rss.dto.ArticleDto
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "channel", strict = false)
data class ChannelDto(
    @field:ElementList(inline = true, name = "item")
    var items: List<ArticleDto> = emptyList()
)
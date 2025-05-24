package com.example.newsaggregator.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.newsaggregator.data.rss.RssFeed
import com.example.newsaggregator.ui.theme.NewsAggregatorTheme
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import nl.adaptivity.xmlutil.serialization.XML
import okhttp3.MediaType
import retrofit2.Retrofit
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp

private val retrofit = Retrofit.Builder()
    .baseUrl("https://www.theguardian.com")
    .addConverterFactory(
        XML.asConverterFactory(
            MediaType.get("application/xml; charset=UTF8")
        )
    ).build()

private val guardian = retrofit.create(RssFeed::class.java)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAggregatorTheme {

                    ArticleScreen(
                       // text = "Press me!",


                    )

            }
        }
    }
}

/*@Composable
fun Greeting(
    text: String,
    modifier: Modifier = Modifier,
    feed: RssFeed,
) {
    val scope = rememberCoroutineScope()
    Button(
        onClick = {
            Log.d("happy", "done")
            scope.launch {
                val r = feed.getRss()
                r.channel.items.forEach {
                    Log.d("link", it.link)
                    Log.d("guid", it.guid)
                    Log.d("dcDate", it.dcDate)
                    Log.d("pubDate", it.pubDate)
                }
            }
        }
    ) {
        Text(
            text = text,
            modifier = modifier,
        )

    }
}*/

@Composable
fun ArticleScreen(viewModel: ArticleViewModel = hiltViewModel()) {
    val articles by viewModel.articles.collectAsState()

    LazyColumn {
        items(items = articles) { article ->

            Text(article.title, modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsAggregatorTheme {
        /*ArticleScreen(
            text = "Press me!",
            feed = guardian
        )*/
    }
}
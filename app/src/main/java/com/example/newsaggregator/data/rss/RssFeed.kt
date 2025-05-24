package com.example.newsaggregator.data.rss

import androidx.transition.Transition.MatchOrder
import com.example.newsaggregator.data.rss.dto.RssDto
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nl.adaptivity.xmlutil.serialization.XML
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Singleton

/*@MatchOrder
@InstallIn(SingletonComponent::class)*/
/*interface RssFeed {
    @GET("/{query}/rss")
    suspend fun getRss(
        @Path("query") query: String = "international"
    ): RssDto
}*/

interface RssFeed {
    @GET("/rss")
    suspend fun getRss(): RssDto
}


class Rss {



    private val BASE_URL = "https://www.theguardian.com/"

   // @Provides
    suspend fun aaa(): RssDto {

        return service.getRss()
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.theguardian.com")
        .addConverterFactory(
            XML.asConverterFactory(
                MediaType.get("application/xml; charset=UTF8")
            )
        ).build()


    private val service = retrofit.create(RssFeed::class.java)


}

package com.example.newsaggregator

import com.example.newsaggregator.data.rss.RssFeed
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nl.adaptivity.xmlutil.serialization.XML
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.theguardian.com")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
    }

    @Provides
    fun provideRssService(retrofit: Retrofit): RssFeed =
        retrofit.create(RssFeed::class.java)
}
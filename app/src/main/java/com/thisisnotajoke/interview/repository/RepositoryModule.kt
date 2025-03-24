package com.thisisnotajoke.interview.repository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideMobileInterviewService(): MobileInterviewRepository {
        return Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/kurtisnelson/2c08d0b40d5f1f4326e5f5eed1b446fa/raw/1c5f9698a67dc554dfe6237f1b4d5c7371a6c3ff/")
            .addConverterFactory(
                Json.asConverterFactory(
                    "application/json; charset=UTF8".toMediaType()))
            .build()
            .create(MobileInterviewRepository::class.java)
    }
}
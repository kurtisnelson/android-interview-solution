package com.thisisnotajoke.interview.di

import com.thisisnotajoke.interview.repository.MobileInterviewRepository
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Provides
import dev.zacsweers.metrox.android.MetroAppComponentProviders
import dev.zacsweers.metrox.viewmodel.ViewModelGraph
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

@DependencyGraph(AppScope::class)
interface AppGraph : MetroAppComponentProviders, ViewModelGraph {

    @Provides
    fun provideMobileInterviewService(): MobileInterviewRepository = Retrofit.Builder()
        .baseUrl("https://gist.githubusercontent.com/kurtisnelson/2c08d0b40d5f1f4326e5f5eed1b446fa/raw/1c5f9698a67dc554dfe6237f1b4d5c7371a6c3ff/")
        .addConverterFactory(
            Json.asConverterFactory(
                "application/json; charset=UTF8".toMediaType()))
        .build()
        .create(MobileInterviewRepository::class.java)
}
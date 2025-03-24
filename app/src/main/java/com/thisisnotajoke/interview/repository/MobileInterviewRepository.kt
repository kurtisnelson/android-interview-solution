package com.thisisnotajoke.interview.repository

import com.thisisnotajoke.interview.model.People
import retrofit2.Response
import retrofit2.http.GET

interface MobileInterviewRepository {
    @GET("people.json")
    suspend fun getPeople(): Response<People>
}

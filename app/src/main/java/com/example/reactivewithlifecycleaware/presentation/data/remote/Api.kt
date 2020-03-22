package com.example.reactivewithlifecycleaware.presentation.data.remote

import com.example.reactivewithlifecycleaware.presentation.data.remote.model.GithubResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/search/users")
    fun fetchUsers(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") limit: Int
    ): Single<GithubResponse>
}
package com.nz.anand.network.api


import com.nz.anand.network.model.RateLimitResponse
import retrofit2.http.GET

interface GitHubAPIInterface {

    @GET("rate_limit")
    suspend fun getRateLimit(): RateLimitResponse
}
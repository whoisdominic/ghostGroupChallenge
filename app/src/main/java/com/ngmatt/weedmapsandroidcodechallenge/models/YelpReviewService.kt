package com.ngmatt.weedmapsandroidcodechallenge.models

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

public interface YelpReviewService {
    @GET("businesses/{id}/reviews")
    fun searchYelp(
        @Header("Authorization") authHeader: String,

    ) : Call<ReviewObject>
}

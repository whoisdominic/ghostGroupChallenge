package com.ngmatt.weedmapsandroidcodechallenge.models

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

public interface YelpBusinessService {

    @GET("businesses/search")
    fun searchYelp(
        @Header("Authorization") authHeader: String,
        @Query("term") searchTerm: String,
        @Query("latitude") latitude: Float,
        @Query("longitude") longitude: Float,
    )
            : Call<Any>
}
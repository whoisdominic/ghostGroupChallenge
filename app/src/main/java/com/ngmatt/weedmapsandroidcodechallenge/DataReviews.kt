package com.ngmatt.weedmapsandroidcodechallenge

import android.util.Log
import com.ngmatt.weedmapsandroidcodechallenge.models.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.typeOf

private const val BASE_URL: String = "https://api.yelp.com/v3/"
private const val API_KEY: String = "HLI3xHwmknNcMui1Xvh-tYi6gSGvYvCHEhJ_za0QNomeSGiMZRZ9qMTAEKoIo7Ob9w-FtdO3Rp1BDyd6gMhwKZdZcQjlqGixYfmlwpW-HiyGxSGCWf6s3kvTKQR-X3Yx"
private const val TAG: String = "DataReview"
class DataReviews {

    companion object {
        var review = ""

        fun createDataSet(id: String): String{
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
            val yelpService = retrofit.create(YelpBusinessService::class.java)
                yelpService.searchReview("Bearer $API_KEY", id).enqueue(object : Callback<ReviewObject> {

                    override fun onResponse(call: Call<ReviewObject>, response: Response<ReviewObject>) {
                        Log.i(TAG, "onResponse $response")
                        val responseBody = response.body()
                        if(responseBody == null){
                            Log.i(TAG, "Error in response")
                        } else {
                            val responseBody = response.body()
                            val topReview = responseBody!!.reviews[0].text
                            Log.i(TAG, "Response ${responseBody.reviews[0].text}")
                                review = topReview
                        }
                    }

                    override fun onFailure(call: Call<ReviewObject>, t: Throwable) {
                        Log.i(TAG, "onFailure $t")
                    }

                })
            return review
        }
    }
}
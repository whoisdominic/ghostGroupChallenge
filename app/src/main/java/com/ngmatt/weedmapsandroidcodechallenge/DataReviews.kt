package com.ngmatt.weedmapsandroidcodechallenge

import android.util.Log
import com.ngmatt.weedmapsandroidcodechallenge.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.typeOf

private const val BASE_URL: String = "https://api.yelp.com/v3/"
private const val API_KEY: String = "HLI3xHwmknNcMui1Xvh-tYi6gSGvYvCHEhJ_za0QNomeSGiMZRZ9qMTAEKoIo7Ob9w-FtdO3Rp1BDyd6gMhwKZdZcQjlqGixYfmlwpW-HiyGxSGCWf6s3kvTKQR-X3Yx"
class DataReviews {

    companion object {

        fun createDataSet(id: String, onGetReview: (String) -> Unit) {
            var review: String = ""
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(YelpBusinessService::class.java)
            GlobalScope.launch(Dispatchers.IO) {
                val response = retrofit.searchReview("Bearer $API_KEY", id)
                if (response.isSuccessful){
                    review = response.body()!!.reviews[0].text.replace("\\s".toRegex(), " ")
                }
                onGetReview(review)
            }
        }
    }
}
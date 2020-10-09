package com.ngmatt.weedmapsandroidcodechallenge

import android.util.Log
import com.ngmatt.weedmapsandroidcodechallenge.models.Business
import com.ngmatt.weedmapsandroidcodechallenge.models.YelpBusiness
import com.ngmatt.weedmapsandroidcodechallenge.models.YelpBusinessService
import com.ngmatt.weedmapsandroidcodechallenge.models.YelpObject
import com.ngmatt.weedmapsandroidcodechallenge.DataReviews
import kotlinx.coroutines.*
import retrofit2.*

import retrofit2.converter.gson.GsonConverterFactory
import java.util.Timer
import kotlin.concurrent.schedule
private const val LATITUDE: Float = 37.786882F
private const val LONGITUDE: Float = -122.399972F
private const val BASE_URL: String = "https://api.yelp.com/v3/"
private const val API_KEY: String = "HLI3xHwmknNcMui1Xvh-tYi6gSGvYvCHEhJ_za0QNomeSGiMZRZ9qMTAEKoIo7Ob9w-FtdO3Rp1BDyd6gMhwKZdZcQjlqGixYfmlwpW-HiyGxSGCWf6s3kvTKQR-X3Yx"
private const val TAG: String = "DataSource"
class DataSource{

    companion object{

        fun createDataSet(query: String?, onSuccessCall: (ArrayList<YelpBusiness>) -> Unit) {
            val yelpData = ArrayList<YelpBusiness>()

            val yelpSearch =  mutableListOf<Business>()

            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(YelpBusinessService::class.java)

            GlobalScope.launch(Dispatchers.IO) {
                val response = retrofit.searchYelp("Bearer $API_KEY", "$query" , LATITUDE, LONGITUDE )
                    yelpSearch.addAll(response.body()!!.businesses)
                   if(response.isSuccessful) {
                       var counter = 0
                       for (location in yelpSearch) {
                            if (counter > 4){
                                Thread.sleep(1001L)
                                counter = 0
                            }
                           val onSuccess: (String) -> Unit = {topReview ->
                               yelpData.add(
                                   YelpBusiness(
                                       location.name,
                                       topReview,
                                       location.image_url,
                                       location.rating
                                   ))
                           }
                           DataReviews.createDataSet(location.id, onSuccess)


                           counter++
                       }

                       onSuccessCall(yelpData)
                   } else {
                       // TODO: Handle Error
                   }
            }
        }
    }
}
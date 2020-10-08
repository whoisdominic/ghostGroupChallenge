package com.ngmatt.weedmapsandroidcodechallenge

import android.util.Log
import com.ngmatt.weedmapsandroidcodechallenge.models.Business
import com.ngmatt.weedmapsandroidcodechallenge.models.YelpBusiness
import com.ngmatt.weedmapsandroidcodechallenge.models.YelpBusinessService
import com.ngmatt.weedmapsandroidcodechallenge.models.YelpObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val LATITUDE: Float = 37.786882F
private const val LONGITUDE: Float = -122.399972F
private const val LOCATION: String = "Los Angeles"
private const val BASE_URL: String = "https://api.yelp.com/v3/"
private const val API_KEY: String = "HLI3xHwmknNcMui1Xvh-tYi6gSGvYvCHEhJ_za0QNomeSGiMZRZ9qMTAEKoIo7Ob9w-FtdO3Rp1BDyd6gMhwKZdZcQjlqGixYfmlwpW-HiyGxSGCWf6s3kvTKQR-X3Yx"
private const val TAG: String = "DataSource"
class DataSource{

    companion object{

        fun createDataSet(query: String?): ArrayList<YelpBusiness>{
            val yelpData = ArrayList<YelpBusiness>()

            val yelpSearch =  mutableListOf<Business>()

            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
            val yelpService = retrofit.create(YelpBusinessService::class.java)
            yelpService.searchYelp("Bearer $API_KEY", "$query" , LATITUDE, LONGITUDE ).enqueue(object : Callback<YelpObject> {

                override fun onResponse(call: Call<YelpObject>, response: Response<YelpObject>) {
                    Log.i(TAG, "onResponse $response")
                    val responseBody = response.body()
                    if(responseBody == null){
                        Log.i(TAG, "Error in response")
                    } else {
                        yelpSearch.addAll(responseBody.businesses)

                        for (location in yelpSearch){
                            Log.i(TAG, "each location ${location.id}")
                            yelpData.add(
                                YelpBusiness(
                                    location.name,
                                    getReviews(location.id),
                                    location.image_url,
                                    location.rating
                            )
                            )

                        }

                    }
                }

                override fun onFailure(call: Call<YelpObject>, t: Throwable) {
                    Log.i(TAG, "onFailure $t")
                }

            })
            return yelpData
        }
        private fun getReviews(id: String): String {
//            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
//            val yelpServiceReview = retrofit.create(YelpBusinessService::class.java)
//                yelpServiceReview.searchReview("Bearer $API_KEY", id)
            return "fake review $id"
        }
    }
}
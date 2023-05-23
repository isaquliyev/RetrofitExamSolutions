package com.example.exam2305task1.network

import com.example.exam2305task1.Constants
import com.example.exam2305task1.api.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientUpcoming {
    companion object {
        var instance: RetrofitClient? = null
        lateinit var myApi: Api
        fun getInstances(): RetrofitClient? {
            if (instance == null) {
                val retrofit: Retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL_UPCOMING)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                myApi = retrofit.create(Api::class.java)
                instance = RetrofitClient()
            }
            return instance
        }
    }

    fun getMyApi(): Api {
        return myApi
    }
}
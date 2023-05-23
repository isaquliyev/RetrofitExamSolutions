package com.example.exam2305task1.api

import com.example.exam2305task1.model.JackReacher
import com.example.exam2305task1.model.UpcomingFilms
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("movie?api_key=4fae678e0bf0ca0ce26f68efa69e3328&query=Jack+Reacher")
    fun getFilms(): Call<JackReacher>

    @GET("w500")
    fun getPhotos(@Query("poster_path")poster_path : String) : Call<JackReacher>

    @GET("upcoming?api_key=4fae678e0bf0ca0ce26f68efa69e3328")
    fun getUpcomingFilms() : Call<UpcomingFilms>
}
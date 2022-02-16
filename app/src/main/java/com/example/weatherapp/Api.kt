package com.example.weatherapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {
    @GET("weather")
    fun getCurrentConditions(
        @Query("zip") zip: String,
        @Query("units") units: String = "imperial",
        @Query("appid") appId: String = "5c9a4b8e3f47b8fc9e9518ea4d2a5bed",
    ): Call<CurrentConditions>


}
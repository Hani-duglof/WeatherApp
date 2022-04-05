package com.gaur.weatherapp.activities

import com.gaur.weatherapp.model.forecast.ForecastDaily
import com.gaur.weatherapp.API.ApiService
import retrofit2.Response
import javax.inject.Inject

class Forecast @Inject constructor(private val apiService: ApiService) {

    suspend fun getSixteenDaysForecast(lat:Double,long:Double): Response<ForecastDaily> {
        return apiService.getSixteenDaysForecast(lat, long)
    }

}
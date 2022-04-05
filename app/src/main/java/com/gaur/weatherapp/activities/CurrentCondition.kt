package com.gaur.weatherapp.activities

import com.gaur.weatherapp.model.WeatherResponseDTO
import com.gaur.weatherapp.API.ApiService
import retrofit2.Response
import javax.inject.Inject

class CurrentCondition @Inject constructor(private val apiService: ApiService) {


    suspend fun getCurrentLocationWeather(lat: Double, long: Double): Response<WeatherResponseDTO> {
        return apiService.getCurrentWeather(lat, long)
    }

}
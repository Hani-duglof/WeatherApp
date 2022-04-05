package com.gaur.weatherapp.activities


import com.gaur.weatherapp.model.WeatherResponseDTO
import com.gaur.weatherapp.API.ApiService
import retrofit2.Response
import javax.inject.Inject

class Search @Inject constructor(private val apiService: ApiService) {


    suspend fun getWeather(zipCode:String): Response<WeatherResponseDTO> {
           return apiService.getWeatherDetails(zipCode)
    }


}
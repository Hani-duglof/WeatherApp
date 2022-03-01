package com.example.weatherapp

import com.squareup.moshi.Json

data class DataForecast(
    val forecasttemp: Float,
    @Json(name ="feels_like") val feelsLike: Float,
    @Json(name ="temp_min") val forecastMin: Float,
    @Json(name ="temp_max") val forecastMax: Float,
    val pressure : Float,
    val humidity: Float,
)
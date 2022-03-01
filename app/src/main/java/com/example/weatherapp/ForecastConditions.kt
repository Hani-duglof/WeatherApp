package com.example.weatherapp

data class ForecastConditions(
    val weather: List<WeatherCondition>,
    val main: Forecast,
    val name: String,

    )

package com.gaur.weatherapp.model

data class ForecastDaily(
    val city: CityName,
    val cnt: Int,
    val cod: String,
    val list: List<DailyWeather>,
    val message: Double
)
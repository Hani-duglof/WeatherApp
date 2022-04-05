package com.gaur.weatherapp.model.forecast

data class ForecastDaily(
    val city: CityName,
    val cnt: Double,
    val cod: String,
    val list: List<DailyWeather>,
    val message: Double
)
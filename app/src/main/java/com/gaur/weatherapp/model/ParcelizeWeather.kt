package com.gaur.weatherapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherResponseDTO(
    val base: String,
    val clouds: Cloud,
    val cod: Int,
    val coord: parcelizeLocation,
    val dt: Int,
    val id: Int,
    val main: Data,
    val name: String,
    val sys: TimeInfo,
    val timezone: Int,
    val visibility: Int,
    val weather: List<DailyWeather>,
    val wind: Wind
): Parcelable
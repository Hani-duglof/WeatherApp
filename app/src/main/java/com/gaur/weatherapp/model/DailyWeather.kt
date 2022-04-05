package com.gaur.weatherapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DailyWeather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
):Parcelable
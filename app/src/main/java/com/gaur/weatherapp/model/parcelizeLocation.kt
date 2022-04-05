package com.gaur.weatherapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class parcelizeLocation(
    val lat: Double,
    val lon: Double
):Parcelable
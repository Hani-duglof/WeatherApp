package com.gaur.weatherapp.Data

sealed class Resource<T>(val data: T? = null, val message: String? = null) {

    class Success<T>(data: T?) : Resource<T>(data = data)

    class Loading<T>(message: String?) : Resource<T>()

    class Error<T>(message: String?) : Resource<T>(message = message)
    class Isolated<T>() : Resource<T>()

}

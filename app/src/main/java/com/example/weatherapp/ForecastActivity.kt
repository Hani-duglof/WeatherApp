package com.example.weatherapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import com.example.weatherapp.ForecastConditions as ForecastConditions

class ForecastActivity : AppCompatActivity() {


    private val apiKey = "5c9a4b8e3f47b8fc9e9518ea4d2a5bed"
    private lateinit var api: Api
    private lateinit var cityName: TextView
    private lateinit var forecastTemp: TextView
    private lateinit var conditionIcon: ImageView
    private lateinit var feelsLike: TextView
    private lateinit var forecastMin: TextView
    private lateinit var forecastMax: TextView
    private lateinit var pressure: TextView
    private lateinit var humidity: TextView
    private lateinit var Sunrise: TextView
    private lateinit var Sunset: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        forecastTemp = findViewById(R.id.temperature1)
        conditionIcon = findViewById(R.id.sun1)
        forecastMin = findViewById(R.id.Low)
        forecastMax = findViewById(R.id.High)
        Sunrise = findViewById(R.id.Sunrise)
        Sunset = findViewById(R.id.sunset)

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://pro.openweathermap.org/data/2.5/weather?q=London,uk&APPID=5c9a4b8e3f47b8fc9e9518ea4d2a5bed")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        api = retrofit.create(api::class.java)
    }

    override fun onResume() {
        super.onResume()


        val call: Call<ForecastConditions> = api.getForecastConditions("55423")
        call.enqueue(object : Callback<ForecastConditions> {
            override fun onResponse(
                call: Call<ForecastConditions>,
                response: Response<ForecastConditions>
            ) {

                val forecastConditions = response.body()
                forecastConditions?.let {
                    bindData(it)
                }


            }

            override fun onFailure(call: Call<ForecastConditions>, t: Throwable) {

            }


        })

    }

    private fun bindData(forecastConditions: ForecastConditions) {

        cityName.text = forecastConditions.name
        findViewById<TextView>(R.id.temperature1).text = forecastTemp.toString()
        findViewById<TextView>(R.id.Low).text = forecastMin.toString()
        findViewById<TextView>(R.id.High).text = forecastMax.toString()

        findViewById<TextView>(R.id.pressure).text = pressure.toString()
        findViewById<TextView>(R.id.Humidity).text = humidity.toString()


        val iconName = forecastConditions.weather.firstOrNull()?.icon
        val iconUrl = "https://openweathermap.org/img/wn/${iconName}@2x.png"
        Glide.with(this)
            .load(iconUrl)
            .into(conditionIcon)
    }

}
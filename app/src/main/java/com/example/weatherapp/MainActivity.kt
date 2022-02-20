package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle;
import android.content.Intent
import android.app.Activity
import android.os.AsyncTask
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {


    private val apiKey = "5c9a4b8e3f47b8fc9e9518ea4d2a5bed"
    private lateinit var api: Api
    private lateinit var cityName: TextView
    private lateinit var currentTemp: TextView
    private lateinit var conditionIcon: ImageView
    private lateinit var feelsLike: TextView
    private lateinit var tempMin: TextView
    private lateinit var tempMax: TextView
    private lateinit var pressure: TextView
    private lateinit var humidity: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.BT)
        button.setOnClickListener {
            val intent = Intent(this, Forecast::class.java)
            startActivity(intent)
        }

        cityName = findViewById(R.id.city_name)
        currentTemp = findViewById(R.id.temperature)
        conditionIcon = findViewById(R.id.condition_icon)
        feelsLike = findViewById(R.id.feels_like)
        tempMin = findViewById(R.id.Low)
        tempMax = findViewById(R.id.High)
        pressure = findViewById(R.id.pressure)
        humidity = findViewById(R.id.Humidity)


        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")

            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        api = retrofit.create(Api::class.java)
    }

    override fun onResume() {
        super.onResume()
        val call: Call<CurrentConditions> = api.getCurrentConditions("55118")
        call.enqueue(object : Callback<CurrentConditions> {
            override fun onResponse(
                call: Call<CurrentConditions>,
                response: Response<CurrentConditions>
            ) {
                val currentConditions = response.body()
                currentConditions?.let {
                    bindData(it)

                }

            }

            override fun onFailure(call: Call<CurrentConditions>, t: Throwable) {

            }


        })

    }

    private fun bindData(currentConditions: CurrentConditions) {
        cityName.text = currentConditions.name
        currentTemp.text = getString(R.string.temperature, currentConditions.main.temp.toInt())
        feelsLike.text = getString(R.string.feels_like, currentConditions.main.feelsLike.toInt())
        tempMin.text = getString(R.string.Low, currentConditions.main.tempMin.toInt())
        tempMax.text = getString(R.string.High, currentConditions.main.tempMax.toInt())
        humidity.text = getString(R.string.humidity, currentConditions.main.humidity.toInt())
        pressure.text = getString(R.string.pressure, currentConditions.main.pressure.toInt())

        val iconName = currentConditions.weather.firstOrNull()?.icon
        val iconUrl = "https://openweathermap.org/img/wn/${iconName}@2x.png"
        Glide.with(this)
            .load(iconUrl)
            .into(conditionIcon)

    }
}
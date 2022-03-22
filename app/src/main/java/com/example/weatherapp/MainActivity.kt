package com.example.weatherapp;

import android.content.Intent

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.weatherapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var viewModel: MaiViewModel

    private val apiKey = "5c9a4b8e3f47b8fc9e9518ea4d2a5bed"
    private lateinit var api: Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button = findViewById<Button>(R.id.BT)
        button.setOnClickListener {
            val intent = Intent(this, Forecast::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.currentConditions.observe(this) { currentConditions ->
            bindData(currentConditions)

        }
        viewModel.loadData()

    }

    private fun bindData(currentConditions: CurrentConditions) {
        binding.cityName.text = currentConditions.name
        binding.temperature.text =
            getString(R.string.temperature, currentConditions.main.temp.toInt())
        binding.feelsLike.text =
            getString(R.string.feels_like, currentConditions.main.feelsLike.toInt())
        binding.Low.text = getString(R.string.Low, currentConditions.main.tempMin.toInt())
        binding.High.text = getString(R.string.High, currentConditions.main.tempMax.toInt())
        binding.Humidity.text =
            getString(R.string.humidity, currentConditions.main.humidity.toInt())
        binding.pressure.text =
            getString(R.string.pressure, currentConditions.main.pressure.toInt())
        val iconName = currentConditions.weather.firstOrNull()?.icon
        val iconUrl = "https://openweathermap.org/img/wn/${iconName}@2x.png"
        Glide.with(this)
            .load(iconUrl)
            .into(binding.conditionIcon)

    }
}
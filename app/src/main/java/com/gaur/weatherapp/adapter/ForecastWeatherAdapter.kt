package com.gaur.weatherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gaur.weatherapp.model.forecast.DailyWeather
import com.gaur.weatherapp.Data.convertIntoDate
import com.gaur.weatherapp.Data.convertMilliTime
import com.gaur.weatherapp.databinding.ViewHolderForecastBinding
import com.gaur.weatherapp.Data.formatUptoOneDecimal

class ForecastWeatherAdapter(private val list: List<DailyWeather>) :
    RecyclerView.Adapter<ForecastWeatherAdapter.MyViewHolder>() {
    inner class MyViewHolder(val viewDataBinding: ViewHolderForecastBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ForecastWeatherAdapter.MyViewHolder {
        val binding = ViewHolderForecastBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ForecastWeatherAdapter.MyViewHolder, position: Int) {

        val binding = holder.viewDataBinding
        val it = this.list[position]
        binding.Temp1.text =
            "Temp " + formatUptoOneDecimal(it.feels_like.day.minus(273) * 9 / 5 + 32)+"°"
        binding.HighTemp1.text =
            "High " + formatUptoOneDecimal(it.temp.max.minus(273) * 9 / 5 + 32)+"°"
        binding.LowTemp1.text =
            "Low " + formatUptoOneDecimal(it.temp.min.minus(273) * 9 / 5 + 32)+"°"
        binding.Sunrise1.text = "Sunrise: " + convertMilliTime(it.sunrise.toLong())
        binding.Sunset1.text = "Sunset: " + convertMilliTime(it.sunset.toLong())
        binding.Date1.text = convertIntoDate(it.dt.toLong())

        Glide.with(binding.sun1)
            .load("https://openweathermap.org/img/wn/${it.weather[0].icon}@2x.png")
            .into(binding.sun1)


    }

    override fun getItemCount(): Int {
        return this.list.size
    }
}
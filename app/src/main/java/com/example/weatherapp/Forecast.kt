package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Forecast : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    val temperature = listOf<ForecastTemp>(
        ForecastTemp(20F, 10F, 37F),
        ForecastTemp(30F, 20F, 36F),
        ForecastTemp(58F, 25F, 20F),
        ForecastTemp(13F, 32F, 20F),
        ForecastTemp(27F, 30F, 19F),
        ForecastTemp(21F, 15F, 18F),
        ForecastTemp(29F, 32F, 24F),
        ForecastTemp(35F, 27F, 35F),
        ForecastTemp(14F, 32F, 27F),
        ForecastTemp(30F, 18F, 31F),
        ForecastTemp(15F, 7F, 20F),
        ForecastTemp(27F, 11F, 24F),
        ForecastTemp(28F, 10F, 30F),
        ForecastTemp(29F, 8F, 31F),
        ForecastTemp(36F, 30F, 36F),
        ForecastTemp(38F, 10F, 30F)


    )

    val adapterData = listOf<Data>(
        Data(1644452968, 1644452968, 1571485599, temperature.get(0), 985F, 61),
        Data(1644539368, 1644539368, 1644449564, temperature.get(1), 1015F, 59),
        Data(1644625768, 1644625768, 1644412964, temperature.get(2), 1005F, 71),
        Data(1644712168, 1644712168, 1644363104, temperature.get(3), 990F, 65),
        Data(1644798568, 1644798568, 1644363104, temperature.get(4), 1115F, 81),
        Data(1644884968, 1644884968, 1571485599, temperature.get(5), 1005F, 57),
        Data(1644971368, 1644971368, 1644449564, temperature.get(6), 989F, 64),
        Data(1645057768, 1645057768, 1644363104, temperature.get(7), 1005F, 70),
        Data(1645144168, 1645144168, 1571485599, temperature.get(8), 1005F, 56),
        Data(1645230568, 1645230568, 1644363104, temperature.get(9), 990F, 69),
        Data(1645316968, 1645316968, 1571485599, temperature.get(10), 900F, 57),
        Data(1645403368, 1645403368, 1644412964, temperature.get(11), 1115F, 56),
        Data(1645489768, 1645489768, 1644363104, temperature.get(12), 1005F, 70),
        Data(1645576168, 1645576168, 1644452968, temperature.get(13), 990F, 61),
        Data(1645662568, 1645662568, 1644449564, temperature.get(14), 1005F, 57),
        Data(1645748968, 1645748968, 1571485599, temperature.get(15), 985F, 64)


    )

    private lateinit var recyclerView1: RecyclerView
    private val adapterData1 = listOf<Data>(

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(adapterData)


    }
}
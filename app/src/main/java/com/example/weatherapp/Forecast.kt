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

    private val adapterData = listOf<Data>(

        Data(date = 1643136300),
        Data(date = 1643222700),
        Data(date = 1643309100),
        Data(date = 1643395500),
        Data(date = 1643481900),
        Data(date = 1643654700),
        Data(date = 1643741100),
        Data(date = 1643827500),
        Data(date = 1643913900),
        Data(date = 1644000300),
        Data(date = 1644086700),
        Data(date = 1644173100),
        Data(date = 1644259500),
        Data(date = 1644345900),
        Data(date = 1644432300),
        Data(date = 1644518700),
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
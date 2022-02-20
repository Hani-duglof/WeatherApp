package com.example.weatherapp

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

class ForecastActivity : AppCompatActivity() {

    val CITY: String = "city_name"
    val API: String = "5c9a4b8e3f47b8fc9e9518ea4d2a5bed"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        weatherTask().execute()

    }

    inner class weatherTask() : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()


            findViewById<RelativeLayout>(R.id.city_name).visibility = View.GONE

        }

        override fun doInBackground(vararg params: String?): String? {
            var response: String?
            try {
                response =
                    URL("https://pro.openweathermap.org/data/2.5/weather?q=London,uk&APPID=5c9a4b8e3f47b8fc9e9518ea4d2a5bed").readText(
                        Charsets.UTF_8
                    )
            } catch (e: Exception) {
                response = null
            }
            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {

                val jsonObj = JSONObject(result)
                val main = jsonObj.getJSONObject("main")
                val sys = jsonObj.getJSONObject("sys")
                val wind = jsonObj.getJSONObject("wind")
                val weather = jsonObj.getJSONArray("weather").getJSONObject(0)

                val updatedAt: Long = jsonObj.getLong("dt")
                val updatedAtText =
                    "Updated at: " + SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(
                        Date(updatedAt * 1000)
                    )
                val temp = main.getString("temp") + "°F"
                val tempMin = "Min Temp: " + main.getString("Low") + "°F"
                val tempMax = "Max Temp: " + main.getString("High") + "°F"
                val pressure = main.getString("pressure")
                val humidity = main.getString("humidity")

                val sunrise: Long = sys.getLong("Sunrise")
                val sunset: Long = sys.getLong("sunset")
                val windSpeed = wind.getString("speed")
                val weatherDescription = weather.getString("description")

                val address = jsonObj.getString("name") + ", " + sys.getString("country")


                findViewById<TextView>(R.id.city_name).text = address
                findViewById<TextView>(R.id.temperature1).text = temp
                findViewById<TextView>(R.id.Low).text = tempMin
                findViewById<TextView>(R.id.High).text = tempMax
                findViewById<TextView>(R.id.Sunrise).text =
                    SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunrise * 1000))
                findViewById<TextView>(R.id.sunset).text =
                    SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunset * 1000))
                findViewById<TextView>(R.id.pressure).text = pressure
                findViewById<TextView>(R.id.Humidity).text = humidity




                findViewById<RelativeLayout>(R.id.city_name).visibility = View.VISIBLE

            } catch (e: Exception) {
            }
        }
    }
}
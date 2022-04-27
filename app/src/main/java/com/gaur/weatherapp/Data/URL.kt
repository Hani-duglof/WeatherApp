package com.gaur.weatherapp.Data

object URL {

    const val BASE_URL = "https://api.openweathermap.org/"
    const val APP_ID = "5c9a4b8e3f47b8fc9e9518ea4d2a5bed"

    const val IMAGE_URL = "notification_image_url"
    const val CONTENT_TITLE = "content_title"
    const val CONTENT_DESC = "content_desc"
    const val CONTENT_TEXT = "content_text"
    const val LOCATION = "location"
    const val TEMPRATURE = "temprature"


    enum class CurrentOrNotification {
        CURRENT, NOTIFICATION
    }


}

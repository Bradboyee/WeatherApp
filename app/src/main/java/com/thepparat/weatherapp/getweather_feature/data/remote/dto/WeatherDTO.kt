package com.thepparat.weatherapp.getweather_feature.data.remote.dto


import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name = "hourly")
    val weatherData: WeatherDataDTO
)
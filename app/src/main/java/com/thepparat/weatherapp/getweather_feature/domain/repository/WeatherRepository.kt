package com.thepparat.weatherapp.getweather_feature.domain.repository

import com.thepparat.weatherapp.getweather_feature.domain.util.Resource
import com.thepparat.weatherapp.getweather_feature.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}
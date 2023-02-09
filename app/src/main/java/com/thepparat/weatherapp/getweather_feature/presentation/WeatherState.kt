package com.thepparat.weatherapp.getweather_feature.presentation

import com.thepparat.weatherapp.getweather_feature.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

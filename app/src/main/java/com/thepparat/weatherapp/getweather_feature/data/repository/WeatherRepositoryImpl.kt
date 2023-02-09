package com.thepparat.weatherapp.getweather_feature.data.repository

import com.thepparat.weatherapp.getweather_feature.data.mappers.toWeatherInfo
import com.thepparat.weatherapp.getweather_feature.data.remote.WeatherApi
import com.thepparat.weatherapp.getweather_feature.domain.repository.WeatherRepository
import com.thepparat.weatherapp.getweather_feature.domain.util.Resource
import com.thepparat.weatherapp.getweather_feature.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(lat = lat, long = long).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(message = e.message ?: "An unknown error occur.")
        }
    }
}
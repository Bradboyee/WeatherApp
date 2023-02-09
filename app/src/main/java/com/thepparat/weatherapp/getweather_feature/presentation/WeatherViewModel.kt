package com.thepparat.weatherapp.getweather_feature.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thepparat.weatherapp.getweather_feature.domain.location.LocationTracker
import com.thepparat.weatherapp.getweather_feature.domain.repository.WeatherRepository
import com.thepparat.weatherapp.getweather_feature.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker,
) : ViewModel() {
    var state by mutableStateOf(WeatherState())
        private set

    fun loadWeatherInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            locationTracker.getCurrentLocation()?.let { location ->
                when (val result =
                    repository.getWeatherData(lat = location.latitude, long = location.longitude)) {
                    is Resource.Success -> {
                        Log.d("API DATA", result.data.toString())
                        state = state.copy(
                            isLoading = false,
                            weatherInfo = result.data,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            isLoading = false,
                            weatherInfo = null,
                            error = result.message
                        )
                    }
                }
            } ?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = "Couldn't retrieve the location. Make sure to grant permission and enable GPS"
                )
            }
        }
    }
}
package com.thepparat.weatherapp.getweather_feature.domain.location

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation() : Location?
}
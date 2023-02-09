package com.thepparat.weatherapp.getweather_feature.di

import com.thepparat.weatherapp.getweather_feature.data.location.DefaultLocationTracker
import com.thepparat.weatherapp.getweather_feature.domain.location.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {

    @Binds
    @Singleton
    abstract fun bindLocationProvider(defaultLocationTracker: DefaultLocationTracker/*which impl*/): LocationTracker // returnn type
}
package com.thepparat.weatherapp.getweather_feature.di

import com.thepparat.weatherapp.getweather_feature.data.repository.WeatherRepositoryImpl
import com.thepparat.weatherapp.getweather_feature.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository
}
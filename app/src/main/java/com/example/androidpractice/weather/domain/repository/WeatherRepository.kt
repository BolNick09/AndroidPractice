package com.example.androidpractice.weather.domain.repository

import com.example.androidpractice.weather.domain.model.WeatherForecast

interface WeatherRepository {

    suspend fun getWeatherForecast(
        latitude: Double,
        longitude: Double
    ): WeatherForecast
}
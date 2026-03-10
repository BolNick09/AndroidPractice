package com.example.androidpractice.weather.domain.usecase

import com.example.androidpractice.weather.domain.model.WeatherForecast
import com.example.androidpractice.weather.domain.repository.WeatherRepository

class GetWeatherForecastUseCase(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(
        latitude: Double,
        longitude: Double
    ): WeatherForecast {
        return repository.getWeatherForecast(latitude, longitude)
    }
}
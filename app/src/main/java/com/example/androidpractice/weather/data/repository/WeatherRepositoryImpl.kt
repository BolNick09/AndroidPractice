package com.example.androidpractice.weather.data.repository

import com.example.androidpractice.weather.data.api.WeatherApi
import com.example.androidpractice.weather.domain.model.ForecastDay
import com.example.androidpractice.weather.domain.model.WeatherForecast
import com.example.androidpractice.weather.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherForecast(
        latitude: Double,
        longitude: Double
    ): WeatherForecast {

        val response = api.getWeatherForecast(
            latitude = latitude,
            longitude = longitude
        )

        val days = response.dataseries.map {

            ForecastDay(
                date = it.date,
                weather = it.weather,
                tempMin = it.temp.min,
                tempMax = it.temp.max,
                windMax = it.windMax
            )
        }

        return WeatherForecast(days)
    }
}
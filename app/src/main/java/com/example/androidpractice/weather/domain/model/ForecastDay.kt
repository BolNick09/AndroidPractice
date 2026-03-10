package com.example.androidpractice.weather.domain.model

data class ForecastDay(
    val date: Int,
    val weather: String,
    val tempMin: Int,
    val tempMax: Int,
    val windMax: Int
)
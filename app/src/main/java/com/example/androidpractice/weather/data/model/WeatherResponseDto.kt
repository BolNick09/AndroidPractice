package com.example.androidpractice.weather.data.model




data class WeatherResponseDto(
    val product: String,
    val init: String,
    val dataseries: List<DataSeriesDto>
)

package com.example.androidpractice.weather.data.model

import com.google.gson.annotations.SerializedName

data class DataSeriesDto(

    @SerializedName("date")
    val date: Int,

    @SerializedName("weather")
    val weather: String,

    @SerializedName("temp2m")
    val temp: TemperatureDto,

    @SerializedName("wind10m_max")
    val windMax: Int
)
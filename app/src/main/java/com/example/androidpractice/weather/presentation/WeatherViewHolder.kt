package com.example.androidpractice.weather.presentation

import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ItemWeatherBinding
import com.example.androidpractice.weather.domain.model.ForecastDay

class WeatherViewHolder(
    private val binding: ItemWeatherBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(day: ForecastDay) {

        binding.textDate.text = day.date.toString()
        binding.textWeather.text = day.weather
        binding.textTemp.text = "${day.tempMin}..${day.tempMax} °C"

        val context = binding.root.context

        if (day.weather.contains("rain", true)) {

            binding.cardWeather.setCardBackgroundColor(
                context.getColor(R.color.weather_rain)
            )

        } else if (day.tempMax < 0) {

            binding.cardWeather.setCardBackgroundColor(
                context.getColor(R.color.weather_cold)
            )

        } else {

            binding.cardWeather.setCardBackgroundColor(
                context.getColor(R.color.weather_warm)
            )
        }
    }
}
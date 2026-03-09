package com.example.androidpractice.weather.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityWeatherBinding
import com.example.androidpractice.weather.data.api.RetrofitClient
import com.example.androidpractice.weather.data.repository.WeatherRepositoryImpl
import com.example.androidpractice.weather.domain.usecase.GetWeatherForecastUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherBinding

    private val repository = WeatherRepositoryImpl(RetrofitClient.weatherApi)
    private val getWeatherForecastUseCase = GetWeatherForecastUseCase(repository)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()

        binding.recyclerWeather.layoutManager = LinearLayoutManager(this)

        loadWeather()
    }

    private fun setupToolbar() {

        setSupportActionBar(binding.toolbarWeather)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.weather_title)

        binding.toolbarWeather.setNavigationOnClickListener {
            finish()
        }
    }

    private fun loadWeather() {

        lifecycleScope.launch {

            val forecast = withContext(Dispatchers.IO) {
                getWeatherForecastUseCase(
                    latitude = 55.75,
                    longitude = 37.61
                )
            }

            binding.recyclerWeather.adapter =
                WeatherAdapter(forecast.days)
        }
    }
}
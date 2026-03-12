package com.example.androidpractice.weather.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidpractice.weather.data.api.RetrofitClient
import com.example.androidpractice.weather.data.repository.WeatherRepositoryImpl
import com.example.androidpractice.weather.domain.model.ForecastDay
import com.example.androidpractice.weather.domain.usecase.GetWeatherForecastUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherViewModel : ViewModel() {

    private val repository = WeatherRepositoryImpl(RetrofitClient.weatherApi)
    private val getWeatherForecastUseCase = GetWeatherForecastUseCase(repository)

    private val _weather = MutableLiveData<List<ForecastDay>>()
    val weather: LiveData<List<ForecastDay>> = _weather

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun loadWeather() {

        viewModelScope.launch {

            try {

                val forecast = withContext(Dispatchers.IO) {
                    getWeatherForecastUseCase(
                        latitude = 55.75,
                        longitude = 37.61
                    )
                }

                _weather.value = forecast.days

            } catch (e: Exception) {

                _error.value = e.message
            }
        }
    }
}
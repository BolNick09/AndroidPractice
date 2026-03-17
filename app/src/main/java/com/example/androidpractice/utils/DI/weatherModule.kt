package com.example.androidpractice.utils.DI

import com.example.androidpractice.weather.data.api.RetrofitClient
import com.example.androidpractice.weather.data.repository.WeatherRepositoryImpl
import com.example.androidpractice.weather.domain.repository.WeatherRepository
import com.example.androidpractice.weather.domain.usecase.GetWeatherForecastUseCase
import com.example.androidpractice.weather.presentation.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherModule = module {

    single {
        RetrofitClient.weatherApi
    }

    single<WeatherRepository> {
        WeatherRepositoryImpl(get())
    }

    factory {
        GetWeatherForecastUseCase(get())
    }

    viewModel {
        WeatherViewModel(get())
    }
}
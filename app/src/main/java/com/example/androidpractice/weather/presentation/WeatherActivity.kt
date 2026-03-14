package com.example.androidpractice.weather.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityWeatherBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherBinding

    private val viewModel: WeatherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()

        binding.recyclerWeather.layoutManager = LinearLayoutManager(this)

        observeViewModel()

        viewModel.loadWeather()
    }

    private fun setupToolbar() {

        setSupportActionBar(binding.toolbarWeather)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.weather_title)

        binding.toolbarWeather.setNavigationOnClickListener {
            finish()
        }
    }

    private fun observeViewModel() {

        viewModel.weather.observe(this) { days ->

            binding.recyclerWeather.adapter = WeatherAdapter(days)
        }

        viewModel.error.observe(this) {

            binding.recyclerWeather.adapter = WeatherAdapter(emptyList())
        }
    }
}
package com.example.androidpractice.weather.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpractice.R
import com.example.androidpractice.databinding.FragmentWeatherBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherFragment : Fragment(R.layout.fragment_weather) {

    private lateinit var binding: FragmentWeatherBinding

    private val viewModel: WeatherViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding = FragmentWeatherBinding.bind(view)

        binding.recyclerWeather.layoutManager =
            LinearLayoutManager(requireContext())

        observeViewModel()
        setupToolbar()

        viewModel.loadWeather()
    }
    private fun setupToolbar() {

        val navController = findNavController()

        binding.toolbarWeather.setupWithNavController(navController)
    }


    private fun observeViewModel() {

        viewModel.weather.observe(viewLifecycleOwner) {

            binding.recyclerWeather.adapter = WeatherAdapter(it)
        }
    }
}
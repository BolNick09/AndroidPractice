package com.example.androidpractice.cars.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityCarsBinding
import com.example.androidpractice.cars.data.repository.CarRepositoryImpl
import com.example.androidpractice.cars.domain.usecase.GetCarsUseCase

class CarsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarsBinding

    private val repository = CarRepositoryImpl()
    private val getCarsUseCase = GetCarsUseCase(repository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCarsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarCars)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.screen_list_title)

        binding.toolbarCars.setNavigationOnClickListener {
            finish()
        }

        binding.recyclerCars.layoutManager = LinearLayoutManager(this)

        val cars = getCarsUseCase.execute()

        val adapter = CarsAdapter(cars)

        binding.recyclerCars.adapter = adapter
    }
}
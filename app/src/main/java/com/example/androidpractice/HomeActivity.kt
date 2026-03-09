package com.example.androidpractice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractice.calculator.presentation.CalculatorActivity
import com.example.androidpractice.databinding.ActivityHomeBinding
import com.example.androidpractice.cars.presentation.CarsActivity
import com.example.androidpractice.weather.presentation.WeatherActivity
import kotlin.jvm.java

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculator.setOnClickListener {
            startActivity(Intent(this, CalculatorActivity::class.java))
        }

        binding.btnList.setOnClickListener {
            startActivity(Intent(this, CarsActivity::class.java))
        }
        binding.btnWeather.setOnClickListener {
            startActivity(
                Intent(this, WeatherActivity::class.java))
        }

    }
}
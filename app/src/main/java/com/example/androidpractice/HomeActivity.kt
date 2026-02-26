package com.example.androidpractice

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractice.databinding.ActivityHomeBinding
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
            startActivity(Intent(this, ListActivity::class.java))
        }

        binding.btnWeather.setOnClickListener {
            startActivity(Intent(this, WeatherActivity::class.java))
        }
    }
}
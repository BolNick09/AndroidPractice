package com.example.androidpractice

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.jvm.java

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.btnCalculator).setOnClickListener {
            startActivity(Intent(this, CalculatorActivity::class.java))
        }

        findViewById<Button>(R.id.btnList).setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }

        findViewById<Button>(R.id.btnWeather).setOnClickListener {
            startActivity(Intent(this, WeatherActivity::class.java))
        }
    }
}
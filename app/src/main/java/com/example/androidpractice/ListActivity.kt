package com.example.androidpractice

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractice.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Делаем Toolbar ActionBar
        setSupportActionBar(binding.toolbar)

        supportActionBar?.title = ""

        // Кнопка "Назад" (иконка + текст — один контейнер)
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
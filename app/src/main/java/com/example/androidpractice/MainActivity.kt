package com.example.androidpractice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.System.currentTimeMillis
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class MainActivity : AppCompatActivity() {
    private val tag = "Test logging";
    private val callTime = currentTimeMillis();
    //Для форматирования даты из мс в человекочитаемый
    private val simpleDateFormat = SimpleDateFormat(
        "yyyy-MM-dd HH:mm:ss.SSS",
        Locale.getDefault());

        override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_main)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            findViewById<Button>(R.id.btnStart).setOnClickListener {
                startActivity(Intent(this, HomeActivity::class.java));

            }
        }

}

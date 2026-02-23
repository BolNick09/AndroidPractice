package com.example.androidpractice

import android.os.Bundle
import android.util.Log
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

            val text = "onCreate called, time: ${simpleDateFormat.format(Date(callTime))}"
            Log.d(tag, text);
        }
    override fun onStart() {
        super.onStart()
        logDelta("onStart")
    }

    override fun onResume() {
        super.onResume()
        logDelta("onResume")
    }

    override fun onPause() {
        super.onPause()
        logDelta("onPause")
    }

    override fun onStop() {
        super.onStop()
        logDelta("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        logDelta("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        logDelta("onDestroy")
    }

    private fun logDelta(eventName: String) {
        val now = currentTimeMillis();
        val delta = now - callTime;

        Log.d(tag, "$eventName called after $delta ms");
    }

}

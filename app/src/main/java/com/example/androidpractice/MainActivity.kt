package com.example.androidpractice

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.System.currentTimeMillis
import kotlin.time.Clock

class MainActivity : AppCompatActivity() {
    val tag = "Test logging";
    val callTime = currentTimeMillis();
    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val text = "onCreate called, time: " + callTime.toString();
        Log.d(tag, text);
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart called");
    }

    override fun onResume() {
        super.onResume()

        Log.d(tag, "onResume called");
    }

    override fun onPause() {
        super.onPause();
        Log.d(tag, "onPause called");
    }
    override fun onStop()
    {
        super.onStop();
        Log.d(tag, "onStop called");
    }

    override fun onRestart() {
        super.onRestart();
        Log.d(tag, "onRestart called");
    }
    override fun onDestroy() {
        super.onDestroy();
        Log.d(tag, "onDestroy called");
    }

}

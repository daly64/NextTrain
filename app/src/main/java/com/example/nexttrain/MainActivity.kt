package com.example.nexttrain

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tunis = findViewById<TextView>(R.id.toTunis)
        val rades = findViewById<TextView>(R.id.toRades)

        TrainTime("Rades", rades, true)
        TrainTime("Tunis", tunis, true)


    }


}
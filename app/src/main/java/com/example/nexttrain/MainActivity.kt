package com.example.nexttrain

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tunis = findViewById<TextView>(R.id.toTunis)
        val rades = findViewById<TextView>(R.id.toRades)

        TrainInterval().radesToTunis(tunis)
        TrainInterval().tunisToRades(rades)


    }


}
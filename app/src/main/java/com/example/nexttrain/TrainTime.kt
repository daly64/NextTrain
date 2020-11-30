package com.example.nexttrain

import android.annotation.SuppressLint
import android.os.CountDownTimer
import android.widget.TextView
import java.time.LocalTime
import java.time.temporal.ChronoUnit


class TrainTime(
    private val destination: String,
    private val label: TextView
) {

    //    set rades time line
    private val tunisToRades = listOf<String>(
        "05:00", "05:30",
        "06:00", "06:20", "06:30", "06:40", "06:55", "07:00", "07:20",
        "07:30", "07:40", "08:00", "08:15", "08:20", "08:30", "08:40",
        "09:00", "09:20", "09:30", "09:40", "10:00", "10:20", "10:30",
        "10:40", "11:00", "11:20", "11:30", "11:40", "12:00", "12:20",
        "12:30", "12:40", "13:00", "13:20", "13:30", "13:40", "14:00",
        "14:20", "14:30", "14:40", "15:00", "15:20", "15:30", "15:40",
        "16:00", "16:20", "16:30", "16:40", "17:00", "17:20", "17:30",
        "17:40", "18:00", "18:20", "18:30", "18:40", "19:00", "19:20",
        "19:30", "19:40", "20:00", "21:00", "21:30", "22:00", "22:30"
    )

    //set tunis time line
    private val radesToTunis = listOf<String>(
        "04:59", "05:30",
        "05:50", "05:59", "06:01", "06:26", "06:34", "06:49", "06:59",
        "07:01", "07:30", "07:46", "07:50", "07:59", "08:01", "08:30",
        "08:50", "08:58", "09:01", "09:35", "09:50", "09:59", "10:01",
        "10:30", "10:50", "10:59", "11:01", "11:30", "11:50", "12:00",
        "12:01", "12:30", "12:50", "12:59", "13:01", "13:30", "13:50",
        "14:00", "14:01", "14:30", "14:50", "14:59", "15:01", "15:30",
        "15:50", "15:59", "16:01", "16:30", "16:50", "16:59", "17:01",
        "17:30", "17:50", "18:00", "18:10", "18:30", "18:50", "19:50",
        "19:30", "20:00", "20:30", "21:00", "21:29", "21:59", "22:29"
    )

    // get current time
    private lateinit var current: LocalTime

    // get train time
    private lateinit var train: LocalTime

    // set i as index variable
    private var i = 0

    private val timer = object : CountDownTimer(1000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            verify()

        }

        override fun onFinish() {
            this.start()


        }
    }

    init {
        // check if timer is enabled
        timer.start()


    }

    private fun verify() {
        current = LocalTime.now()
        when (destination) {
            "Tunis" ->
                // get train time
                train = LocalTime.parse(radesToTunis[i])

            "Rades" ->
                // get train time
                train = LocalTime.parse(tunisToRades[i])

        }

        // if train time is after current
        if (train.isAfter(current)) notPassed()

        // if train time is before current time
        if (train.isBefore(current)) passed()
    }

    // set what to do if train has not passed yet
    private fun notPassed() {
        remain(current, train)
    }

    // set what to do if train has passed
    private fun passed() {
        if (i < radesToTunis.lastIndex || i < tunisToRades.lastIndex) {
            i++
            verify()
        } else i = 0
    }

    @SuppressLint("SetTextI18n")
    // calculate remain time
    private fun remain(fromTime: LocalTime, toTime: LocalTime) {
        // get time interval between tow times in seconds
        val interval = fromTime.until(toTime, ChronoUnit.SECONDS)
        val h = interval / 3600
        val mn = interval % 3600 / 60
        val s = interval % 3600 % 60
        val remain = String.format("%02d:%02d:%02d", h, mn, s)
        label.text =
            "the train to $destination is for $train\n you still have  $remain "
    }


}
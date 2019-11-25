package com.example.passenger.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.passenger.R
import kotlinx.android.synthetic.main.activity_seat_booking.*

class SeatBookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_booking)

        seatBooking.setImageResource(R.drawable.person_ash)

        var iconColor = "ash"

        seatBooking.setOnClickListener {
            Log.i("color", iconColor)
            if (iconColor == "ash") {
                seatBooking.setColorFilter(Color.GREEN)
                iconColor = "green"
            } else if (iconColor == "green") {
                seatBooking.setColorFilter(Color.GRAY)
                iconColor = "ash"
            }
        }
    }
}


package com.example.passenger.ui

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.passenger.R
import kotlinx.android.synthetic.main.activity_seat_booking.*

class SeatBookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_booking)

        //seatBooking.setImageResource(R.drawable.person_ash)


        seat1.setOnClickListener {
            book(seat1)
        }
        seat2.setOnClickListener {
            book(seat2)
        }
        seat3.setOnClickListener {
            book(seat3)
        }
        seat4.setOnClickListener {
            book(seat4)
        }
        seat5.setOnClickListener {
            book(seat5)
        }
        seat6.setOnClickListener {
            book(seat6)
        }
        seat7.setOnClickListener {
            book(seat7)
        }
        seat8.setOnClickListener {
            book(seat8)
        }

        seat9.setOnClickListener {
            book(seat9)
        }
        seat10.setOnClickListener {
            book(seat10)
        }
        seat11.setOnClickListener {
            book(seat11)
        }
        seat12.setOnClickListener {
            book(seat12)
        }
        seat13.setOnClickListener {
            book(seat13)
        }
        seat14.setOnClickListener {
            book(seat14)
        }
        seat15.setOnClickListener {
            book(seat15)
        }
        seat16.setOnClickListener {
            book(seat16)
        }

        seat17.setOnClickListener {
            book(seat17)
        }
        seat18.setOnClickListener {
            book(seat18)
        }
        seat19.setOnClickListener {
            book(seat19)
        }
        seat20.setOnClickListener {
            book(seat20)
        }
        seat21.setOnClickListener {
            book(seat21)
        }
        seat22.setOnClickListener {
            book(seat22)
        }
        seat23.setOnClickListener {
            book(seat23)
        }
        seat24.setOnClickListener {
            book(seat24)
        }

        seat25.setOnClickListener {
            book(seat25)
        }
        seat26.setOnClickListener {
            book(seat26)
        }
        seat27.setOnClickListener {
            book(seat27)
        }
        seat28.setOnClickListener {
            book(seat28)
        }
        seat29.setOnClickListener {
            book(seat29)
        }
        seat30.setOnClickListener {
            book(seat30)
        }
        seat31.setOnClickListener {
            book(seat31)
        }
        seat32.setOnClickListener {
            book(seat32)
        }


    }

    var iconColor = "ash"
    private fun book(seatNo: ImageView) {
        if (iconColor == "ash") {
            seatNo.setColorFilter(Color.GREEN)
            iconColor = "green"
        } else if (iconColor == "green") {
            seatNo.setColorFilter(Color.GRAY)
            iconColor = "ash"
        }
    }
}



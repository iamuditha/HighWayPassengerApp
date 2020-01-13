package com.example.passenger.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.passenger.Bus1SeatsRepository
import com.example.passenger.R
import kotlinx.android.synthetic.main.activity_seat_booking.*


class SeatBookingActivity : AppCompatActivity() {

    private var BusSeatRepo = Bus1SeatsRepository()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_booking)

        val busId = intent.getIntExtra("id", 1)
        Log.i("mId", busId.toString())
        var data = BusSeatRepo.fetchBusData()
        Log.i("seat", data.toString())
        Log.i("seat", data[busId].toString())
        Log.i("seat", data.size.toString())
        Log.i("seat", data[busId].s1.toString())

        if (!data[busId].s1) {
            seat1.setColorFilter(Color.RED)
        }
        if (!data[busId].s2) {
            seat2.setColorFilter(Color.RED)
        }
        if (!data[busId].s3) {
            seat3.setColorFilter(Color.RED)
        }
        if (!data[busId].s4) {
            seat4.setColorFilter(Color.RED)
        }
        if (!data[busId].s5) {
            seat5.setColorFilter(Color.RED)
        }
        if (!data[busId].s6) {
            seat6.setColorFilter(Color.RED)
        }
        if (!data[busId].s7) {
            seat7.setColorFilter(Color.RED)
        }
        if (!data[busId].s8) {
            seat8.setColorFilter(Color.RED)
        }
        if (!data[busId].s9) {
            seat9.setColorFilter(Color.RED)
        }
        if (!data[busId].s10) {
            seat10.setColorFilter(Color.RED)
        }
        if (!data[busId].s11) {
            seat11.setColorFilter(Color.RED)
        }
        if (!data[busId].s12) {
            seat12.setColorFilter(Color.RED)
        }
        if (!data[busId].s13) {
            seat13.setColorFilter(Color.RED)
        }
        if (!data[busId].s14) {
            seat14.setColorFilter(Color.RED)
        }
        if (!data[busId].s15) {
            seat15.setColorFilter(Color.RED)
        }
        if (!data[busId].s16) {
            seat16.setColorFilter(Color.RED)
        }
        if (!data[busId].s17) {
            seat17.setColorFilter(Color.RED)
        }
        if (!data[busId].s18) {
            seat18.setColorFilter(Color.RED)
        }
        if (!data[busId].s19) {
            seat19.setColorFilter(Color.RED)
        }
        if (!data[busId].s20) {
            seat20.setColorFilter(Color.RED)
        }
        if (!data[busId].s21) {
            seat21.setColorFilter(Color.RED)
        }
        if (!data[busId].s22) {
            seat22.setColorFilter(Color.RED)
        }
        if (!data[busId].s23) {
            seat23.setColorFilter(Color.RED)
        }
        if (!data[busId].s24) {
            seat24.setColorFilter(Color.RED)
        }
        if (!data[busId].s25) {
            seat25.setColorFilter(Color.RED)
        }
        if (!data[busId].s26) {
            seat26.setColorFilter(Color.RED)
        }
        if (!data[busId].s27) {
            seat27.setColorFilter(Color.RED)
        }
        if (!data[busId].s28) {
            seat28.setColorFilter(Color.RED)
        }
        if (!data[busId].s29) {
            seat29.setColorFilter(Color.RED)
        }
        if (!data[busId].s30) {
            seat30.setColorFilter(Color.RED)
        }
        if (!data[busId].s31) {
            seat31.setColorFilter(Color.RED)
        }
        if (!data[busId].s32) {
            seat32.setColorFilter(Color.RED)
        }





        //seatBooking.setImageResource(R.drawable.person_ash)


        seat1.setOnClickListener {
            book(seat1, data[busId].s1)
        }
        seat2.setOnClickListener {
            book(seat2, data[busId].s2)
        }
        seat3.setOnClickListener {
            book(seat3, data[busId].s3)
        }
        seat4.setOnClickListener {
            book(seat4, data[busId].s4)
        }
        seat5.setOnClickListener {
            book(seat5, data[busId].s5)
        }
        seat6.setOnClickListener {
            book(seat6, data[busId].s6)
        }
        seat7.setOnClickListener {
            book(seat7, data[busId].s7)
        }
        seat8.setOnClickListener {
            book(seat8, data[busId].s8)
        }

        seat9.setOnClickListener {
            book(seat9, data[busId].s9)
        }
        seat10.setOnClickListener {
            book(seat10, data[busId].s10)
        }
        seat11.setOnClickListener {
            book(seat11, data[busId].s11)
        }
        seat12.setOnClickListener {
            book(seat12, data[busId].s12)
        }
        seat13.setOnClickListener {
            book(seat13, data[busId].s13)
        }
        seat14.setOnClickListener {
            book(seat14, data[busId].s14)
        }
        seat15.setOnClickListener {
            book(seat15, data[busId].s15)
        }
        seat16.setOnClickListener {
            book(seat16, data[busId].s16)
        }

        seat17.setOnClickListener {
            book(seat17, data[busId].s17)
        }
        seat18.setOnClickListener {
            book(seat18, data[busId].s18)
        }
        seat19.setOnClickListener {
            book(seat19, data[busId].s19)
        }
        seat20.setOnClickListener {
            book(seat20, data[busId].s20)
        }
        seat21.setOnClickListener {
            book(seat21, data[busId].s21)
        }
        seat22.setOnClickListener {
            book(seat22, data[busId].s22)
        }
        seat23.setOnClickListener {
            book(seat23, data[busId].s23)
        }
        seat24.setOnClickListener {
            book(seat24, data[busId].s24)
        }

        seat25.setOnClickListener {
            book(seat25, data[busId].s25)
        }
        seat26.setOnClickListener {
            book(seat26, data[busId].s26)
        }
        seat27.setOnClickListener {
            book(seat27, data[busId].s27)
        }
        seat28.setOnClickListener {
            book(seat28, data[busId].s28)
        }
        seat29.setOnClickListener {
            book(seat29, data[busId].s29)
        }
        seat30.setOnClickListener {
            book(seat30, data[busId].s30)
        }
        seat31.setOnClickListener {
            book(seat31, data[busId].s31)
        }
        seat32.setOnClickListener {
            book(seat32, data[busId].s32)
        }


    }

    var iconColor = "ash"
    private fun book(seatNo: ImageView, status: Boolean) {
        if (iconColor == "ash" && status) {
            seatNo.setColorFilter(Color.GREEN)
            iconColor = "green"
        } else if (iconColor == "green" && status) {
            seatNo.setColorFilter(Color.GRAY)
            iconColor = "ash"
        }
    }
}



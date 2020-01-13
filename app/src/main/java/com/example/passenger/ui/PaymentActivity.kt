package com.example.passenger.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.passenger.R
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        val id = intent.getIntExtra("id", 1)
        pay.setOnClickListener {
            val intent = Intent(this, SeatBookingActivity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }
    }
}

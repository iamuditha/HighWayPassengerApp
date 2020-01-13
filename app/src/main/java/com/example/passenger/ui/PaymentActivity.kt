package com.example.passenger.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.passenger.R
import kotlinx.android.synthetic.main.activity_payment.*


class PaymentActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        var ticketPrice: Int = 0

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        val id = intent.getIntExtra("id", 1)
        val route = intent.getStringExtra("rou")
        val type = intent.getStringExtra("typ")
        Log.i("mRoute", type)
//        pay.setOnClickListener {
//            val intent = Intent(this, SeatBookingActivity::class.java)
//            intent.putExtra("id", id)
//            startActivity(intent)
//        }


        if (route == "Colombo -> Matara" || route == "Matara -> Colombo") {
            ticketPrice = 600
            price.text = ticketPrice.toString()
        }
        if (route == "Matara -> Kaduwela" || route == "Kaduwela -> Matara") {
            ticketPrice = 500
            price.text = ticketPrice.toString()
        }

        if (route == "Matara -> Makumbura" || route == "Makumbura -> Matara") {
            ticketPrice = 400
            price.text = ticketPrice.toString()
        }

        if (type == "Office Bus") {
            discount.visibility = View.VISIBLE
        }

        proceed.setOnClickListener {
            if (type == "Office Bus") {
                val tot =
                    ((adultCount.text.toString().toInt() * ticketPrice + childrenCount.text.toString().toInt() * ticketPrice * 0.5) * 0.9).toString()
                total.text =
                    ((adultCount.text.toString().toInt() * ticketPrice + childrenCount.text.toString().toInt() * ticketPrice * 0.5) * 0.9).toString()
                totallText.visibility = View.VISIBLE
                total.visibility = View.VISIBLE
                pay.visibility = View.VISIBLE
            } else {


                val tot =
                    (adultCount.text.toString().toInt() * ticketPrice + childrenCount.text.toString().toInt() * ticketPrice * 0.5).toString()
                total.text =
                    (adultCount.text.toString().toInt() * ticketPrice + childrenCount.text.toString().toInt() * ticketPrice * 0.5).toString()
                totallText.visibility = View.VISIBLE
                total.visibility = View.VISIBLE
                pay.visibility = View.VISIBLE
            }

        }

        pay.setOnClickListener {
            if (type == "Office Bus") {
                val tot =
                    ((adultCount.text.toString().toInt() * ticketPrice + childrenCount.text.toString().toInt() * ticketPrice * 0.5) * 0.9).toString()
                val intent = Intent(this, PayActivity::class.java)
                intent.putExtra("payment", tot)
                intent.putExtra("id", id)
                startActivity(intent)

            } else {
                val tot =
                    (adultCount.text.toString().toInt() * ticketPrice + childrenCount.text.toString().toInt() * ticketPrice * 0.5).toString()

                val intent = Intent(this, PayActivity::class.java)
                intent.putExtra("payment", tot)
                intent.putExtra("id", id)
                startActivity(intent)

            }


        }

    }
}

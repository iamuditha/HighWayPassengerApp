package com.example.passenger.ui

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.passenger.R
import kotlinx.android.synthetic.main.activity_pay.*

class PayActivity : AppCompatActivity() {

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelID = "com.example.passenger"
    private val description = "Test notification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)
        val payment = intent.getStringExtra("payment")
        Log.i("pay", payment)
        val id = intent.getIntExtra("id", 1)

        val halfPayment = (payment.toDouble() * 0.5).toString()
        amountDisplay.text = halfPayment


        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


        completePayment.setOnClickListener {

            val intent = Intent(this, LauncherActivity::class.java)
            val pendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel =
                    NotificationChannel(channelID, description, NotificationManager.IMPORTANCE_HIGH)
                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.GREEN
                notificationChannel.enableVibration(true)
                notificationManager.createNotificationChannel(notificationChannel)

                builder = Notification.Builder(this, channelID)
                    .setContentTitle("Successfully done the payment")
                    .setContentText("You Have paid RS. $halfPayment to reserve the seats")
                    .setSmallIcon(R.drawable.ic_launcher_round)
                    .setLargeIcon(
                        BitmapFactory.decodeResource(
                            this.resources,
                            R.drawable.ic_launcher_round
                        )
                    )
                    .setContentIntent(pendingIntent)


            } else {
                builder = Notification.Builder(this)
                    .setContentTitle("Successfully done the payment")
                    .setContentText("You Have paid RS. $payment to reserve the seats")
                    .setSmallIcon(R.drawable.ic_launcher_round)
                    .setLargeIcon(
                        BitmapFactory.decodeResource(
                            this.resources,
                            R.drawable.ic_launcher_round
                        )
                    )
                    .setContentIntent(pendingIntent)

            }
            notificationManager.notify(134, builder.build())

            val intent1 = Intent(this, SeatBookingActivity::class.java)
            intent1.putExtra("id", id)
            startActivity(intent1)
        }





    }


}

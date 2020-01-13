package com.example.passenger.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.passenger.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bus_list_item.view.*


class MainActivity : AppCompatActivity() {


    private val BusRepo = BusDetailRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Rou = intent.getStringExtra("route")


        val data = BusRepo.fetchBusData()
        populateListView(data, Rou)

//    Log.i("passing",Rou)
    }

    private fun populateListView(data: List<Bus>, Route: String) {
        photographerList.apply {
            //setHasFixedSize(true)
            Log.v("test4", "populateListView called")
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PhotographerAdapter(context, data, Route)
            Log.v("test4", "populateListView called")
        }
    }
}


class PhotographerAdapter(var context: Context, private val data: List<Bus>, val route: String) :
    RecyclerView.Adapter<PhotographerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val timeText: TextView = view.timeText
        val ratingText: TextView = view.temperatureText
        val descriptionText: TextView = view.descriptionText
        val routeText: TextView = view.routeText
    }

    //create new view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.v("test1", "onCreateViewHolder called $viewType")
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.bus_list_item, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bus = data[position]
        Log.v("test3", "onBindViewHolder called " + bus.id)
        if (bus.route == route) {
            Log.v("test3", "printed " + bus.id)
            val id = bus.id
            holder.timeText.text = bus.time
            holder.descriptionText.text = bus.description
            holder.ratingText.text = "rating" + " " + bus.ratings.toString()//.formatTemperature()
            holder.routeText.text = bus.route
            holder.descriptionText.setOnClickListener {
                val intent = Intent(context, PaymentActivity::class.java)
                intent.putExtra("id", id)
                Log.i("mId", id.toString())
                context.startActivity(intent)
            }

        }


    }

    private fun seatBooking(id: Int) {
        val intent = Intent(context, SeatBookingActivity::class.java)
        intent.putExtra("id", id)
        Log.i("mId", id.toString())
        context.startActivity(intent)
    }

    override fun getItemCount(): Int {
        Log.v("test2", "getItemCount called is " + data.count().toString())
        return data.count()
    }

}
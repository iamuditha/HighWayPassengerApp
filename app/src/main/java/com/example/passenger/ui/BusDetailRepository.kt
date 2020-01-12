package com.example.passenger.ui

class BusDetailRepository {

    fun fetchBusData(): List<Bus> {
        return listOf(
            Bus(1, "8:30", 4.5F, "fg-85412", "Matara -> Makumbura"),
            Bus(2, "9:00", 5.0f, "gf-5689", "Colombo -> Matara"),
            Bus(3, "9:30", 4.0f, "jg-7856", "Colombo -> Matara"),
            Bus(4, "10:00", 2.0f, "er-4856", "Matara -> Makumbura"),
            Bus(5, "10:30", 4.0f, "84-8563", "Matara -> Makumbura"),
            Bus(6, "11:00", 5.0f, "74-8523", "Matara -> Makumbura"),
            Bus(7, "11:30", 5.0f, "yp-8745", "Matara -> Makumbura"),
            Bus(8, "12:00", 3.0f, "fg-7777", "Colombo -> Matara"),
            Bus(9, "12:30", 2.0f, "as-7213", "Colombo -> Matara"),
            Bus(10, "13:00", 2.0f, "gg-0124", "Colombo -> Matara"),
            Bus(11, "13:30", 4.6f, "ip-8896", "Colombo -> Matara"),
            Bus(12, "14:00", 3.0f, "qw-75321", "Colombo -> Matara"),
            Bus(13, "14:30", 4.7f, "kl-7853", "Colombo -> Matara"),
            Bus(14, "15:00", 4.0f, "cv-7853", "Colombo -> Matara"),
            Bus(15, "15:30", 4.0f, "lp-3666", "Colombo -> Matara"),
            Bus(16, "16:00", 5.0f, "yy-7423", "Colombo -> Matara"),
            Bus(17, "16:30", 5.0f, "jj-8743", "Colombo -> Matara"),
            Bus(18, "17:00", 5.0f, "45-6589", "Colombo -> Matara")

        )
    }
}
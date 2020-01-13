package com.example.passenger.ui

class BusDetailRepository {

    fun fetchBusData(): List<Bus> {
        return listOf(
            Bus(1, "8:30", 4.5F, "fg-85412", "Matara -> Makumbura", "Private Bus"),
            Bus(2, "9:00", 5.0f, "gf-5689", "Matara -> Makumbura", "Private Bus"),
            Bus(3, "9:30", 4.0f, "jg-7856", "Matara -> Makumbura", "Private Bus"),
            Bus(4, "10:00", 2.0f, "er-4856", "Matara -> Makumbura", "Private Bus"),
            Bus(5, "10:30", 4.0f, "84-8563", "Matara -> Makumbura", "Office Bus"),
            Bus(6, "11:00", 5.0f, "74-8523", "Matara -> Makumbura", "Office Bus"),
            Bus(7, "11:30", 5.0f, "yp-8745", "Matara -> Makumbura", "Office Bus"),
            Bus(8, "12:00", 3.0f, "fg-7777", "Colombo -> Matara", "Private Bus"),
            Bus(9, "12:30", 2.0f, "as-7213", "Colombo -> Matara", "Private Bus"),
            Bus(10, "13:00", 2.0f, "gg-0124", "Colombo -> Matara", "Private Bus"),
            Bus(11, "13:30", 4.6f, "ip-8896", "Colombo -> Matara", "Private Bus"),
            Bus(12, "14:00", 3.0f, "qw-75321", "Colombo -> Matara", "SLTB"),
            Bus(13, "14:30", 4.7f, "kl-7853", "Colombo -> Matara", "SLTB"),
            Bus(14, "15:00", 4.0f, "cv-7853", "Colombo -> Matara", "SLTB"),
            Bus(15, "15:30", 4.0f, "lp-3666", "Colombo -> Matara", "SLTB"),
            Bus(16, "16:00", 5.0f, "yy-7423", "Colombo -> Matara", "Office Bus"),
            Bus(17, "16:30", 5.0f, "jj-8743", "Colombo -> Matara", "Office Bus"),
            Bus(18, "17:00", 5.0f, "45-6589", "Colombo -> Matara", "Office Bus")

        )
    }
}
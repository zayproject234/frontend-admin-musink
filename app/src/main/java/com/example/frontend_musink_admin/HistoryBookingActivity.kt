package com.example.frontend_musink_admin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryBookingActivity : AppCompatActivity() {

    private lateinit var rvHistory: RecyclerView
    private lateinit var adapter: BookingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_booking)

        rvHistory = findViewById(R.id.rvHistory)
        rvHistory.layoutManager = LinearLayoutManager(this)

        // Dummy data history booking
        val historyBookings = listOf(
            Booking("1", "Senin, 17 Jun 2024", "10.00 - 12.00", "accepted"),
            Booking("2", "Selasa, 18 Jun 2024", "13.00 - 15.00", "rejected"),
            Booking("3", "Rabu, 19 Jun 2024", "15.00 - 17.00", "accepted"),
            Booking("4", "Kamis, 20 Jun 2024", "09.00 - 11.00", "rejected")
        )

        adapter = BookingAdapter(historyBookings) { booking ->
            Toast.makeText(this, "Detail Booking ID: ${booking.id}", Toast.LENGTH_SHORT).show()
        }

        rvHistory.adapter = adapter
    }
}

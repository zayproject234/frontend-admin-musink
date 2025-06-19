package com.example.frontend_musink_admin

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AdminBookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_booking)

        // Tombol Book Requests
        val btnBookRequests = findViewById<Button>(R.id.btnBookRequests)
        btnBookRequests.setOnClickListener {
            Toast.makeText(this, "Fitur Book Requests belum tersedia", Toast.LENGTH_SHORT).show()
        }

        // Setup listener untuk semua slot booking
        findViewById<TextView>(R.id.slot09).setOnClickListener(createSlotListener("09.00", "Missed"))
        findViewById<TextView>(R.id.slot10).setOnClickListener(createSlotListener("10.00", "Other Band Book"))
        findViewById<TextView>(R.id.slot11).setOnClickListener(createSlotListener("11.00", "Missed"))
        findViewById<TextView>(R.id.slot12).setOnClickListener(createSlotListener("12.00", "Other Band Book"))
        findViewById<TextView>(R.id.slot13).setOnClickListener(createSlotListener("13.00", "Available"))
        findViewById<TextView>(R.id.slot14).setOnClickListener(createSlotListener("14.00", "Available"))
    }

    // Fungsi untuk menghasilkan OnClickListener dengan parameter View
    private fun createSlotListener(time: String, status: String): View.OnClickListener {
        return View.OnClickListener {
            when (status) {
                "Available" -> Toast.makeText(this, "Slot $time masih tersedia", Toast.LENGTH_SHORT).show()
                "Other Band Book" -> Toast.makeText(this, "Slot $time sudah dibooking band lain", Toast.LENGTH_SHORT).show()
                "Missed" -> Toast.makeText(this, "Slot $time sudah terlewat", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this, "Slot $time tidak dikenali", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

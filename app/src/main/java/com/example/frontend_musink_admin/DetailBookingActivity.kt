package com.example.frontend_musink_admin

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailBookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_booking)

        val btnConfirm = findViewById<Button>(R.id.btnConfirm)
        val btnReject = findViewById<Button>(R.id.btnReject)
        val imgProof = findViewById<ImageView>(R.id.imgProof)

        btnConfirm.setOnClickListener {
            Toast.makeText(this, "Booking dikonfirmasi", Toast.LENGTH_SHORT).show()
        }

        btnReject.setOnClickListener {
            Toast.makeText(this, "Booking ditolak", Toast.LENGTH_SHORT).show()
        }

        imgProof.setOnClickListener {
            Toast.makeText(this, "Bukti pembayaran ditampilkan (belum diimplementasi)", Toast.LENGTH_SHORT).show()
        }
    }
}

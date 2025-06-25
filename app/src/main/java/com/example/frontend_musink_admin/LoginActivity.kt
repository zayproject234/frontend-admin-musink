package com.example.frontend_musink_admin

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.etUsername)
        val password = findViewById<EditText>(R.id.etPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val googleButton = findViewById<Button>(R.id.btnGoogle)

        loginButton.setOnClickListener {
            val user = username.text.toString().trim()
            val pass = password.text.toString().trim()

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Isi semua data", Toast.LENGTH_SHORT).show()
            } else if (user == "admin@gmail.com" && pass == "Admin123") {
                Toast.makeText(this, "Login berhasil sebagai Admin", Toast.LENGTH_SHORT).show()

                // Pindah ke halaman AdminBookingActivity
                val intent = Intent(this, AdminBookingActivity::class.java)
                startActivity(intent)
                finish() // Menutup LoginActivity supaya tidak bisa balik dengan tombol back
            } else {
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        }

        googleButton.setOnClickListener {
            Toast.makeText(this, "Google login belum diimplementasikan", Toast.LENGTH_SHORT).show()
        }
    }
}

package com.example.frontend_musink_admin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val editProfileBtn = findViewById<Button>(R.id.btnEditProfile)
        val logoutBtn = findViewById<Button>(R.id.btnLogout)
        //val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        editProfileBtn.setOnClickListener {
            // Ganti dengan activity edit profil kamu
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }

        logoutBtn.setOnClickListener {
            // Aksi logout misalnya kembali ke LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

       /* bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.nav_documents -> {
                    startActivity(Intent(this, DocumentActivity::class.java))
                    true
                }
                R.id.nav_profile -> {
                    // Sudah di halaman profil
                    true
                }
                else -> false
            }
        }
        */
    }
}

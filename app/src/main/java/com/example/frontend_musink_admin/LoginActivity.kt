package com.example.frontend_musink_admin

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.etUsername)
        val password = findViewById<EditText>(R.id.etPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val googleButton = findViewById<Button>(R.id.btnGoogle)

        loginButton.setOnClickListener {
            val user = username.text.toString()
            val pass = password.text.toString()

            if (user.isNotEmpty() && pass.isNotEmpty()) {
                val request = LoginRequest(user, pass)

                ApiClient.instance.login(request).enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        if (response.isSuccessful) {
                            val loginResponse = response.body()
                            if (loginResponse?.status == 200) {
                                val userData = loginResponse.data
                                Toast.makeText(
                                    this@LoginActivity,
                                    "Selamat datang, ${userData.username}",
                                    Toast.LENGTH_SHORT
                                ).show()

                                // TODO: Pindah ke halaman lain (jika ada)
                                // val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                                // startActivity(intent)
                                // finish()

                            } else {
                                Toast.makeText(
                                    this@LoginActivity,
                                    loginResponse?.message ?: "Login gagal",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Toast.makeText(this@LoginActivity, "Login gagal (code: ${response.code()})", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(this@LoginActivity, "Terjadi kesalahan: ${t.localizedMessage}", Toast.LENGTH_SHORT).show()
                    }
                })

            } else {
                Toast.makeText(this, "Isi semua data", Toast.LENGTH_SHORT).show()
            }
        }

        googleButton.setOnClickListener {
            Toast.makeText(this, "Google login belum diimplementasikan", Toast.LENGTH_SHORT).show()
        }
    }
}

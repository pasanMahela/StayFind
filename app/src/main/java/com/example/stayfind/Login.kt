package com.example.stayfind

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            val mobile = findViewById<EditText>(R.id.mobileNumber).text.toString()
            val password = findViewById<EditText>(R.id.password).text.toString()

            if (mobile.isEmpty() || password.isEmpty()) {
                // Show an error message
                Toast.makeText(this, "Enter Mobile number and Password", Toast.LENGTH_SHORT).show()
            } else {
                // Proceed with the intent
                val intent = Intent(this, HomePage::class.java)
                startActivity(intent)
            }
        }

        val signupButton = findViewById<TextView>(R.id.signUpSub)
        signupButton.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
    }
}
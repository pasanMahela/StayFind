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

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val loginButton = findViewById<TextView>(R.id.signInSub)
        loginButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val loginButton2 = findViewById<Button>(R.id.signUpButton)
        loginButton2.setOnClickListener {
            val mobile = findViewById<EditText>(R.id.mobileNumber).text.toString()
            val password = findViewById<EditText>(R.id.password).text.toString()

            if (mobile.isEmpty() || password.isEmpty()) {
                // Show an error message
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Proceed with the intent
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
            }
        }
    }
}
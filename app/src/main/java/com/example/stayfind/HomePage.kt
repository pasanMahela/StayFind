package com.example.stayfind

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setSelectedItemId(R.id.home)

        bottomNavigationView.setOnItemSelectedListener { item ->
            val intent: Intent
            val options: ActivityOptionsCompat

            when (item.itemId) {
                R.id.home -> return@setOnItemSelectedListener true
                R.id.search -> {
                    intent = Intent(applicationContext, SearchPage::class.java)
                }
                R.id.adpost -> {
                    intent = Intent(applicationContext, PostAddPage::class.java)
                }
                R.id.save -> {
                    intent = Intent(applicationContext, SavePage::class.java)
                }
                R.id.profile -> {
                    intent = Intent(applicationContext, ProfilePage::class.java)
                }
                else -> return@setOnItemSelectedListener false
            }

            options = ActivityOptionsCompat.makeCustomAnimation(
                applicationContext,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )
            startActivity(intent, options.toBundle())
            finish()
            true
        }

        val viewButton = findViewById<ImageView>(R.id.boarding1)
        viewButton.setOnClickListener {
            val intent = Intent(this, ViewPost::class.java)
            startActivity(intent)
        }

    }
}
package com.example.rentablayout

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rentablayout.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val fullName = intent.getStringExtra("FULLNAME")
        val email = intent.getStringExtra("EMAIL")
        return when(item.itemId) {
            R.id.option_profile -> {
                val intentToProfile = Intent(this@DashboardActivity, ProfileActivity::class.java).apply {
                    putExtra("FULLNAME", fullName)
                    putExtra("EMAIL", email)
                }
                startActivity(intentToProfile)
                true
            }
            R.id.option_logout -> {
                val intentToLogin = Intent(this@DashboardActivity, MainActivity::class.java)
                startActivity(intentToLogin)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
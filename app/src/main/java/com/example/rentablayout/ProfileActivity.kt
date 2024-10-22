package com.example.rentablayout

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rentablayout.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityProfileBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        with(binding) {
            val fullName = intent.getStringExtra("FULLNAME")
            val email = intent.getStringExtra("EMAIL")

            showFullName.text = fullName
            showEmail.text = email
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profile_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.option_logout -> {
                val intentToLogin = Intent(this@ProfileActivity, MainActivity::class.java)
                startActivity(intentToLogin)
                true
            }
            R.id.option_back -> {
                val intetToDashboard = Intent(this@ProfileActivity, DashboardActivity::class.java)
                startActivity(intetToDashboard)
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }
}
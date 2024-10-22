package com.example.rentablayout

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity.MODE_PRIVATE
import com.example.rentablayout.databinding.FragmentLoginBinding
import kotlin.math.log

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val loginBtn = view.findViewById<Button>(R.id.btn_login)

        val fullnameInput = view.findViewById<EditText>(R.id.edt_full_name)
        val passwordInput = view.findViewById<EditText>(R.id.edt_password)

        val fullname = arguments?.getString("FULLNAME")
        val password = arguments?.getString("PASSWORD")
        val email = arguments?.getString("EMAIL")

        loginBtn.setOnClickListener {
            if (fullnameInput.text.toString() != fullname || passwordInput.text.toString() != password){
                fullnameInput.error = "Wrong email or password"
                passwordInput.error = "Wrong email or password"
                return@setOnClickListener
            } else{
                val intentToDashboard = Intent(activity, DashboardActivity::class.java).apply{
                    putExtra("EMAIL", email)
                    putExtra("FULLNAME", fullname)
                }

                startActivity(intentToDashboard)
            }
        }

        return view
    }
}
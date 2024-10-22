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

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding ? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val email = arguments?.getString("email")
        val fullName = arguments?.getString("fullName")
        val nim = arguments?.getString("nim")
        val password = arguments?.getString("password")

        with(binding) {
            btnLogin.setOnClickListener {
                if (binding.edtEmail.text.toString().isEmpty() ||
                    binding.edtPassword.text.toString().isEmpty()) {
                    binding.edtEmail.error = "Email Can't be Blank"
                    binding.edtPassword.error = "Password Can't be Blank"
                    return@setOnClickListener
                } else if (binding.edtPassword.text.toString() != password ||
                    binding.edtEmail.text.toString() != email) {
                    binding.edtEmail.error = "Wrong Password or Email"
                    binding.edtPassword.error = "Wrong Password or Email"
                    return@setOnClickListener
                } else {
                    val intentToDashboardActivity = Intent(activity, DashboardActivity::class.java).apply {
                        putExtra("email", email)
                        putExtra("fullName", fullName)
                        putExtra("nim", nim)
                        putExtra("password", password)
                    }
                    startActivity(intentToDashboardActivity)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
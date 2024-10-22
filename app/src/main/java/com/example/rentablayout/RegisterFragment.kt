package com.example.rentablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.rentablayout.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        val regisBtn = view.findViewById<Button>(R.id.btn_register)
        val emailInput = view.findViewById<EditText>(R.id.edt_email)
        val fullnameInput = view.findViewById<EditText>(R.id.edt_full_name)
        val passwordInput = view.findViewById<EditText>(R.id.edt_password)

        regisBtn.setOnClickListener {
            val loginArgs = Bundle().apply {
                putString("EMAIL", emailInput.text.toString())
                putString("FULLNAME", fullnameInput.text.toString())
                putString("PASSWORD", passwordInput.text.toString())
            }

            val sectionPagerAdapter = SectionPagerAdapter(requireActivity()
                    as AppCompatActivity, loginArgs)
            val viewPager : ViewPager2 = requireActivity().findViewById(R.id.view_pager)
            viewPager.adapter = sectionPagerAdapter
        }
        return view
    }

}
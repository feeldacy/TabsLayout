package com.example.rentablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.rentablayout.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnRegister.setOnClickListener {
                val loginArgs = Bundle().apply {
                    putString("email", edtEmail.text.toString())
                    putString("fullName", edtFullName.text.toString())
                    putString("nim", edtNim.text.toString())
                    putString("password", edtPassword.text.toString())
                }

                val sectionPagerAdapter = SectionPagerAdapter(requireActivity()
                        as AppCompatActivity, loginArgs)
                val viewPager : ViewPager2 = requireActivity().findViewById(R.id.view_pager)
                viewPager.adapter = sectionPagerAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
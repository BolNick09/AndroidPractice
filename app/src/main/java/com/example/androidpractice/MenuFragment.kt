package com.example.androidpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidpractice.databinding.FragmentMenuBinding

class MenuFragment : Fragment(R.layout.fragment_menu) {

    private lateinit var binding: FragmentMenuBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding = FragmentMenuBinding.bind(view)

        binding.buttonCalculator.setOnClickListener {

            findNavController().navigate(
                R.id.action_menuFragment_to_calculatorFragment
            )
        }

        binding.buttonWeather.setOnClickListener {

            findNavController().navigate(
                R.id.action_menuFragment_to_weatherFragment
            )
        }
    }
}
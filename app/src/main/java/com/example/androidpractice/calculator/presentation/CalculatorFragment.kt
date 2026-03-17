package com.example.androidpractice.calculator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.androidpractice.databinding.FragmentCalculatorBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CalculatorViewModel by viewModel()

    private var expression = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupButtons()

        viewModel.result.observe(viewLifecycleOwner) {
            binding.textResult.text = it
        }
    }
    private fun setupButtons() {
        binding.button0.setOnClickListener { append("0") }
        binding.button1.setOnClickListener { append("1") }
        binding.button2.setOnClickListener { append("2") }
        binding.button3.setOnClickListener { append("3") }
        binding.button4.setOnClickListener { append("4") }
        binding.button5.setOnClickListener { append("5") }
        binding.button6.setOnClickListener { append("6") }
        binding.button7.setOnClickListener { append("7") }
        binding.button8.setOnClickListener { append("8") }
        binding.button9.setOnClickListener { append("9") }


        binding.buttonPlus.setOnClickListener { append("+") }
        binding.buttonMinus.setOnClickListener { append("-") }
        binding.buttonMultiply.setOnClickListener { append("*") }
        binding.buttonDivide.setOnClickListener { append("/") }

        binding.buttonOpen.setOnClickListener { append("(") }
        binding.buttonClose.setOnClickListener { append(")") }
        binding.buttonDot.setOnClickListener { append(".") }

        binding.buttonClear.setOnClickListener {

            expression = ""
            binding.textExpression.text = ""
            binding.textResult.text = ""
        }

        binding.buttonEquals.setOnClickListener {

            viewModel.calculate(expression)
        }
    }
    private fun setupToolbar() {

        val navController = findNavController()

        binding.calculatorToolbar.setupWithNavController(navController)
    }

    private fun append(value: String) {

        expression += value

        binding.textExpression.text = expression
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
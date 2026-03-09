package com.example.androidpractice.calculator.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorBinding

    private val viewModel: CalculatorViewModel by viewModels()

    private var expression = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.calculatorToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.calculator_title)

        binding.calculatorToolbar.setNavigationOnClickListener {
            finish()
        }

        setupButtons()

        viewModel.result.observe(this) {

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

    private fun append(value: String) {

        expression += value

        binding.textExpression.text = expression
    }
}
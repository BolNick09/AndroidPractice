package com.example.androidpractice.calculator.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidpractice.calculator.domain.usecase.CalculateExpressionUseCase

class CalculatorViewModel(
    private val calculateUseCase: CalculateExpressionUseCase
) : ViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    fun calculate(expression: String) {

        try {

            val value = calculateUseCase.execute(expression)

            _result.value = value.toString()

        } catch (e: Exception) {

            _result.value = e.message
        }
    }
}
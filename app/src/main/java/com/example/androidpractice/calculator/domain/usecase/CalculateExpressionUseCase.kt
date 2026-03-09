package com.example.androidpractice.calculator.domain.usecase

import com.example.androidpractice.calculator.domain.repository.CalculatorRepository

class CalculateExpressionUseCase(
    private val repository: CalculatorRepository
) {

    fun execute(expression: String): Double {

        return repository.calculate(expression)
    }
}
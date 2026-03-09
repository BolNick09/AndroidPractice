package com.example.androidpractice.calculator.domain.usecase

import com.example.androidpractice.calculator.domain.model.CalculatorOperation

class CalculateUseCase {

    fun execute(operation: CalculatorOperation): Double {

        return when (operation.operator) {

            "+" -> operation.first + operation.second
            "-" -> operation.first - operation.second
            "*" -> operation.first * operation.second
            "/" -> operation.first / operation.second

            else -> 0.0
        }
    }
}
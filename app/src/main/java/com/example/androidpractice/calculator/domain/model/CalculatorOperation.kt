package com.example.androidpractice.calculator.domain.model

data class CalculatorOperation(
    val first: Double,
    val second: Double,
    val operator: String
)
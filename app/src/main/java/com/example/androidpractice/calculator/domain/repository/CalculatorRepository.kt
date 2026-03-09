package com.example.androidpractice.calculator.domain.repository

interface CalculatorRepository {

    fun calculate(expression: String): Double
}
package com.example.androidpractice.calculator.data.repository

import com.example.androidpractice.calculator.domain.repository.CalculatorRepository
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorRepositoryImpl : CalculatorRepository {

    override fun calculate(expression: String): Double {

        val exp = ExpressionBuilder(expression).build()

        return exp.evaluate()
    }
}
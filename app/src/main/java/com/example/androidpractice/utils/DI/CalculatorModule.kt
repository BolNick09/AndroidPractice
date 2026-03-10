package com.example.androidpractice.utils.DI

import com.example.androidpractice.calculator.data.repository.CalculatorRepositoryImpl
import com.example.androidpractice.calculator.domain.repository.CalculatorRepository
import com.example.androidpractice.calculator.domain.usecase.CalculateExpressionUseCase
import com.example.androidpractice.calculator.presentation.CalculatorViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val calculatorModule = module {

    single<CalculatorRepository> {
        CalculatorRepositoryImpl()
    }

    single {
        CalculateExpressionUseCase(get())
    }

    viewModel {
        CalculatorViewModel(get())
    }
}
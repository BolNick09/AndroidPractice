package com.example.androidpractice.cars.domain.usecase

import com.example.androidpractice.cars.data.model.Car
import com.example.androidpractice.cars.domain.repository.CarRepository

class GetCarsUseCase(
    private val repository: CarRepository
) {

    fun execute(): List<Car> {

        return repository.getCars()
    }
}
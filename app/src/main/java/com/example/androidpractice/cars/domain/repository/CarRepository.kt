package com.example.androidpractice.cars.domain.repository

import com.example.androidpractice.cars.data.model.Car

interface CarRepository {

    fun getCars(): List<Car>
}
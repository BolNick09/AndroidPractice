package com.example.androidpractice.cars.data.repository

import com.example.androidpractice.R
import com.example.androidpractice.cars.data.model.Car
import com.example.androidpractice.cars.domain.repository.CarRepository

class CarRepositoryImpl : CarRepository {

    override fun getCars(): List<Car> {

        return listOf(

            Car("Toyota", "Camry", 2020, "Седан", 4500000, R.drawable.ic_car_placeholder),
            Car("BMW", "X5", 2019, "Кроссовер", 6500000, R.drawable.ic_car_placeholder),
            Car("Audi", "A6", 2021, "Бизнес-класс", 5900000, R.drawable.ic_car_placeholder),
            Car("Toyota", "Camry", 2020, "Седан", 4500000, R.drawable.ic_car_placeholder),
            Car("BMW", "X5", 2019, "Кроссовер", 6500000, R.drawable.ic_car_placeholder),
            Car("Audi", "A6", 2021, "Бизнес-класс", 5900000, R.drawable.ic_car_placeholder),
            Car("Toyota", "Camry", 2020, "Седан", 4500000, R.drawable.ic_car_placeholder),
            Car("BMW", "X5", 2019, "Кроссовер", 6500000, R.drawable.ic_car_placeholder),
            Car("Audi", "A6", 2021, "Бизнес-класс", 5900000, R.drawable.ic_car_placeholder),
            Car("Toyota", "Camry", 2020, "Седан", 4500000, R.drawable.ic_car_placeholder),
            Car("BMW", "X5", 2019, "Кроссовер", 6500000, R.drawable.ic_car_placeholder),
            Car("Audi", "A6", 2021, "Бизнес-класс", 5900000, R.drawable.ic_car_placeholder),
            Car("Toyota", "Camry", 2020, "Седан", 4500000, R.drawable.ic_car_placeholder),
            Car("BMW", "X5", 2019, "Кроссовер", 6500000, R.drawable.ic_car_placeholder),
            Car("Audi", "A6", 2021, "Бизнес-класс", 5900000, R.drawable.ic_car_placeholder),
            Car("Toyota", "Camry", 2020, "Седан", 4500000, R.drawable.ic_car_placeholder),
            Car("BMW", "X5", 2019, "Кроссовер", 6500000, R.drawable.ic_car_placeholder),
            Car("Audi", "A6", 2021, "Бизнес-класс", 5900000, R.drawable.ic_car_placeholder),
            Car("Toyota", "Camry", 2020, "Седан", 4500000, R.drawable.ic_car_placeholder),
            Car("BMW", "X5", 2019, "Кроссовер", 6500000, R.drawable.ic_car_placeholder),
            Car("Audi", "A6", 2021, "Бизнес-класс", 5900000, R.drawable.ic_car_placeholder),
            Car("Toyota", "Camry", 2020, "Седан", 4500000, R.drawable.ic_car_placeholder),
            Car("BMW", "X5", 2019, "Кроссовер", 6500000, R.drawable.ic_car_placeholder),
            Car("Audi", "A6", 2021, "Бизнес-класс", 5900000, R.drawable.ic_car_placeholder),
        )
    }
}
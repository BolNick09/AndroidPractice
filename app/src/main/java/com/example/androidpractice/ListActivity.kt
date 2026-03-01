package com.example.androidpractice

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpractice.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        val cars = listOf(
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

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CarAdapter(cars)
    }
}
package com.example.androidpractice.cars.presentation

import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractice.databinding.ItemCarBinding
import com.example.androidpractice.cars.data.model.Car

class CarsViewHolder(
    private val binding: ItemCarBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(car: Car) {

        binding.textBrand.text = car.brand
        binding.textModel.text = car.model
        binding.textYear.text = car.year.toString()
        binding.textDescription.text = car.description
        binding.textCost.text = car.cost.toString()

        binding.imageCar.setImageResource(car.imageResId)
    }
}
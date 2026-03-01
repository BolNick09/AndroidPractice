package com.example.androidpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractice.databinding.ItemCarBinding

class CarAdapter(
    private val items: List<Car>
) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    class CarViewHolder(
        private val binding: ItemCarBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(car: Car) {
            binding.tvTitle.text =
                "${car.brand} ${car.model} (${car.year})"
            binding.tvDescription.text =
                "${car.description}, ${car.cost} ₽"
            binding.imgCar.setImageResource(car.imageResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
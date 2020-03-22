package com.example.reactivewithlifecycleaware.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.reactivewithlifecycleaware.R
import com.example.reactivewithlifecycleaware.presentation.main.MainContract
import java.lang.IllegalStateException

class MainAdapter : ListAdapter<MainContract.ListViewObject, RecyclerView.ViewHolder>(
    DiffUtil()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)
        return when (viewType) {
            R.layout.item_linear_car_model -> LinearViewHolder(
                view
            )
            R.layout.layout_grid_car_model -> GridViewHolder(
                view
            )
            else -> throw IllegalStateException("No view support for this type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LinearViewHolder -> {
                holder.bind(getItem(position).carModel)
            }
            is GridViewHolder -> {
                holder.bind(getItem(position).carModel)
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is MainContract.ListViewObject.Linear -> {
                R.layout.item_linear_car_model
            }
            is MainContract.ListViewObject.Grid -> R.layout.layout_grid_car_model
            else -> -1
        }
    }
}
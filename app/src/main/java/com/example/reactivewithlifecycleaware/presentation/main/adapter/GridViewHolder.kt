package com.example.reactivewithlifecycleaware.presentation.main.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.reactivewithlifecycleaware.util.CarModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_grid_car_model.*

class GridViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {
    fun bind(item: CarModel) {
        title.text = item.name
        brand.text = item.brand
        imageView.load(item.gallery.images.first()) {
        }
    }
}
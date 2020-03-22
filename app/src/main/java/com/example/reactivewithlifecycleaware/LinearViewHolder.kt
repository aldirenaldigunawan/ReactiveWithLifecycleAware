package com.example.reactivewithlifecycleaware

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_linear_car_model.*

class LinearViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(item: CarModel) {
        brand.text = item.brand
        title.text = " ${item.name}"
        price.text = item.price
        description.text = item.description
        imageView.load(item.gallery.images.first()) {
            transformations(RoundedCornersTransformation(containerView.context.dpToPx(8).toFloat()))
        }
    }

}
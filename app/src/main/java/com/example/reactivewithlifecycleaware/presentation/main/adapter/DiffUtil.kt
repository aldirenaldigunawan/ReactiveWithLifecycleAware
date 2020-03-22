package com.example.reactivewithlifecycleaware.presentation.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.reactivewithlifecycleaware.presentation.main.MainContract

class DiffUtil : DiffUtil.ItemCallback<MainContract.ListViewObject>() {
    override fun areItemsTheSame(oldItem: MainContract.ListViewObject, newItem: MainContract.ListViewObject): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MainContract.ListViewObject, newItem: MainContract.ListViewObject): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}
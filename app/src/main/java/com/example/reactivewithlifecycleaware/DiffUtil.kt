package com.example.reactivewithlifecycleaware

import androidx.recyclerview.widget.DiffUtil

class DiffUtil : DiffUtil.ItemCallback<MainContract.ListViewObject>() {
    override fun areItemsTheSame(oldItem: MainContract.ListViewObject, newItem: MainContract.ListViewObject): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MainContract.ListViewObject, newItem: MainContract.ListViewObject): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}